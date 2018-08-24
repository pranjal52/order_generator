package com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnecttion;

public class generatorDAO {
	
	public int addEmployee(Employee emp) {
		String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE1 VALUES (?,?,?)";
		try {
			PreparedStatement ps = MyConnecttion.getMyConnection().prepareStatement(INSERT_EMPLOYEE);
			ps.setInt(1,emp.getEmpId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getSalary());
			
			
			r=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

}
