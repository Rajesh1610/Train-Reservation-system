package com.demo.train.reservation.repo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.train.reservation.connection.DatabaseConnection;

public class TrainRepo {
	public void displayTrainInfo() throws SQLException {
		String query = "Select * from train";
		Connection con = DatabaseConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Train No: " + rs.getInt(1));
			if(rs.getInt(2)==0)
				System.out.println("AC: no ");
			else
				System.out.println("AC: yes ");
			System.out.println("Capacity: " + rs.getInt(3));
		}
		
		System.out.println("-------------------    ----------------      -----------------------");
	}
	
	public int getCapacity(int id) throws SQLException {
		String query = "Select capacity from train where id=" + id;
		Connection con = DatabaseConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}





