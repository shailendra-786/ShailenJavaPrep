package com.utility.DateJava8;

import java.time.LocalDate;

public class LocalDateManipulation {
	public static void main(String[] args) {

		LocalDate currentDate = LocalDate.now();

		// Adding or changing year
		LocalDate futureYear = currentDate.withYear(2024);
		System.out.println("Date with Future Year: " + futureYear);

		LocalDate addNumberToYear = currentDate.plusYears(1);
		System.out.println("addNumberToYear " + addNumberToYear);

		LocalDate substractNumberToYear = currentDate.minusYears(1);
		System.out.println("substractNumberToYear " + substractNumberToYear);

		// Adding or changing month
		LocalDate nextMonth = currentDate.withMonth(9); // September
		System.out.println("Date with Next Month: " + nextMonth);

		LocalDate addMonth = currentDate.plusMonths(1);
		LocalDate subMonth = currentDate.minusMonths(1);
		System.out.println("addMonth " + addMonth + " subMonth " + subMonth);

		// Adding or changing day of the month
		LocalDate nextDay = currentDate.withDayOfMonth(29);
		System.out.println("Date with Next Day: " + nextDay);

		LocalDate addDay = currentDate.plusDays(30);
		LocalDate subDay = currentDate.minusDays(30);
		System.out.println("addDay " + addDay + " subDay " + subDay);

	}
}
