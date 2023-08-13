package com.utility.DateJava8;

import java.time.LocalDate;

public class LocalDateBasic {

	public static void main(String[] args) {
		// Creating a LocalDate
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date: " + currentDate);

		// Creating a specific date
		LocalDate specificDate = LocalDate.of(2023, 8, 12);
		System.out.println("Specific Date: " + specificDate);

		// Getting components of a date
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		int day = currentDate.getDayOfMonth();
		System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);

	}

}
