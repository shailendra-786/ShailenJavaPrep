package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at john@example.com or info@company.org for more information. my email Email12.%_+-aa@aaaA99.-.com";

        String pattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Email: " + matcher.group());
        }
    }
}
