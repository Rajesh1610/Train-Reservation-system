package com.demo.train.reservation.controller;

import java.util.*;

import com.demo.train.reservation.repo.BookingRepo;
import com.demo.train.reservation.repo.TrainRepo;
import com.demo.train.reservation.service.Booking;

public class TrainMain {

	public static void main(String[] args) {

		TrainRepo tr = new TrainRepo();

		try {
			tr.displayTrainInfo();

			int userOption = 1;
			Scanner scanner = new Scanner(System.in);

			while (userOption == 1) {
				System.out.println("Enter 1 to Book and 2 to exit");
				userOption = scanner.nextInt();
				if (userOption == 1) {
					Booking booking = new Booking();
					if (booking.isAvailable()) {
						BookingRepo bro = new BookingRepo();
						bro.addBooking(booking);
						System.out.println("Your booking is confirmed");
					} else
						System.out.println("Sorry. Train is full. Try another Train or date.");
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
