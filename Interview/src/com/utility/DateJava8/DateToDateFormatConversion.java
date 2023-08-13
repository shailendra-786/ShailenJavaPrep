package com.utility.DateJava8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateToDateFormatConversion {

	public static void main(String[] args) {
		// Create a LocalDate object
		LocalDate currentDate = LocalDate.now();

        // Define the desired output format
        String outputPattern = "MMMM dd, yyyy"; // Customize the pattern as needed

        // Create a DateTimeFormatter with the output pattern
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern);

        // Format the LocalDate using the output formatter
        String formattedDate = currentDate.format(outputFormatter);
        System.out.println("Formatted Date: " + formattedDate);	
        
        
        LocalDate localDate = LocalDate.parse(formattedDate, outputFormatter);
        System.out.println("Converted LocalDate: " + localDate);
    }
}






//        // Create a Date object
//        Date currentDate = new Date();
//
//        // Define the desired output format
//        String outputPattern = "MMMM dd, yyyy"; // Customize the pattern as needed
//
//        // Create a SimpleDateFormat with the output pattern
//        SimpleDateFormat outputFormatter = new SimpleDateFormat(outputPattern);
//
//        // Format the Date using the output formatter
//        String formattedDate = outputFormatter.format(currentDate);
//
//        System.out.println("Formatted Date: " + formattedDate);