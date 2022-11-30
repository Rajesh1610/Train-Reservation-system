package com.demo.train.reservation.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.demo.train.reservation.connection.DatabaseConnection;
import com.demo.train.reservation.service.Booking;

public class BookingRepo {

	public int getBookedCount(int trainNo, Date date) throws SQLException {

		String query = "select count(passenger_name) from booking where train_no=? and travel_date=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, trainNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public void addBooking(Booking booking) throws SQLException {
		String query = "Insert into booking values(?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.trainNo);
		pst.setDate(3, sqldate);

		pst.executeUpdate();

	}
}
