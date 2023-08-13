package com.utility.DateJava8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeDate {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalDate localDate = currentDate.plusDays(3).plusMonths(2).plusYears(1);

		String pattern = "MMMM dd ,yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String updateDateWithFormat = localDate.format(formatter);
		System.out.println(updateDateWithFormat);

		// back to the localDate
		LocalDate date = LocalDate.parse(updateDateWithFormat, formatter);
		System.out.println(date);

	}
}
