package com.utility.DateJava8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StringToDateFormatConversion {
	public static void main(String[] args) {
//	MMMM dd, yyyy
//	dd/MM/yyyy
//	MM/dd/yyyy
//	yyyy-MM-dd
		// here we parsing string into date
		String dateString = "2023-08-12"; // Example date string
		String pattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern); // if pattern and dateString which you parse
																			// must be same format or else exception
		LocalDate parsedDate = LocalDate.parse(dateString, formatter);
		System.out.println("Parsed Date: " + parsedDate);

		// another way.....
		String inputDate = "2023-08-12";
		// parse inputDate
		LocalDate parseInputDate = LocalDate.parse(inputDate);
		// Create a DateTimeFormatter for the desired output format
		String pattern1="MM/dd/yyyy";
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern1, Locale.ENGLISH);
		 // Format the date using the output formatter
        String formattedDate = parseInputDate.format(outputFormatter);

        System.out.println("Formatted Date: " + formattedDate);

	}
}
