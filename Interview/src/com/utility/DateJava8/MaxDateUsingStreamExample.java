package com.utility.DateJava8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaxDateUsingStreamExample {
public static void main(String[] args) {
	// Create a list of LocalDate objects
    List<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.of(2023, 8, 12));
    dates.add(LocalDate.of(2023, 7, 15));
    dates.add(LocalDate.of(2023, 9, 1));
    dates.add(LocalDate.of(2023, 6, 20));
    
    LocalDate date = dates.stream().max(LocalDate::compareTo).orElse(null);
    System.out.println(date);
}
}
