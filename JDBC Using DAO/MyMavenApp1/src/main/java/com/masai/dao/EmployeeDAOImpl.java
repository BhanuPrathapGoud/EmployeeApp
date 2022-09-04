package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.masai.EmployeeException.EmployeeException;
import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		List<Employee> list = new ArrayList<>();
		try(Connection conn = DBUtil.provoidConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int i= rs.getInt("empid");
				String n= rs.getString("name");
				String a= rs.getString("address");
				int s= rs.getInt("salary");
				Employee employee = new Employee();
				employee.setEmpId(i);
				employee.setName(n);
				employee.setAddress(a);
				employee.setSalary(s);
				list.add(employee);
			}
			if(list.size()==0) {
				throw new EmployeeException("Employee data not found");
			}
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return list;
	}

	@Override
	public String getAddressOfEmployee(int empId) throws EmployeeException {
		String address = null;
		try(Connection conn = DBUtil.provoidConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Employee where empid = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				address = rs.getString("address");
				
			}else {
				throw new EmployeeException("Employee ID not found "+empId);
			}
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return address;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus)   throws EmployeeException {
		String result = "Bonus Not added";
		try(Connection conn = DBUtil.provoidConnection()){
			PreparedStatement ps = conn.prepareStatement("update Employee set salary = salary+? where empid = ?");
			ps.setInt(1, bonus);
			ps.setInt(2, empId);
			int x = ps.executeUpdate();
			if(x > 0)
				result="Inserted Sucessfully ! ";
			else
				 throw new EmployeeException("Data not Inserted");
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {
		boolean result = false;
		try(Connection conn = DBUtil.provoidConnection()){
			PreparedStatement ps = conn.prepareStatement("delete from Employee where empid = ?");
			ps.setInt(1, empId);
			int x = ps.executeUpdate();
			if(x > 0) {
				result = true;
			}
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return result;
	}

	@Override
	public String[] getNameAndAddress(int empId) throws EmployeeException {
		String[] list = new String[2];
		try(Connection conn = DBUtil.provoidConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Employee where empId = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int i= rs.getInt("empid");
				String n= rs.getString("name");
				String a= rs.getString("address");
				int s= rs.getInt("salary");
				list[0] = n;
				list[1] = a;
			}
			else{
				throw new EmployeeException("Employee data not found");
			}
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return list;
	}

}
