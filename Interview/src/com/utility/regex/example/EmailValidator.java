package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String[] emails = {
            "user@example.com",
            "john.doe@example",
            "invalid_email",
            "test123@example.co.uk"
        };

        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9]+\\.)+[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            boolean isValid = matcher.matches();
            System.out.println(email + " is " + (isValid ? "valid" : "invalid") + " email.");
        }
    }
}
