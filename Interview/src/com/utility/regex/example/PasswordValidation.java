package com.utility.regex.example;

import java.util.regex.Pattern;

public class PasswordValidation {
    public static void main(String[] args) {
        String password = "P@ssw0rd";

        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        boolean isValid = Pattern.matches(pattern, password);
        
        if (isValid) {
            System.out.println("Valid password.");
        } else {
            System.out.println("Invalid password.");
        }
    }
}
