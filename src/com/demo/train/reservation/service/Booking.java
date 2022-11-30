package com.demo.train.reservation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.train.reservation.repo.BookingRepo;
import com.demo.train.reservation.repo.TrainRepo;

public class Booking {
	public String passengerName;
	public int trainNo;
	public Date date;

	public Booking() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter passenger Name...:");
		passengerName = sc.next();
		System.out.println("Enter Train Number..");
		trainNo = sc.nextInt();
		System.out.println("Enter date dd-mm-yyyy format");
		String dateInput = sc.next();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateformat.parse(dateInput);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		sc.close();
	}

	public boolean isAvailable() throws Exception {
		TrainRepo tr = new TrainRepo();
		BookingRepo bro = new BookingRepo();
		int capacity = tr.getCapacity(trainNo);

		int booked = bro.getBookedCount(trainNo, date);

		return booked < capacity;

	}

}
