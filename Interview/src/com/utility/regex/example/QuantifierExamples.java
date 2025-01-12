package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifierExamples {
    public static void main(String[] args) {
        String text = "aaab aab ab";

        Pattern pattern1 = Pattern.compile("a*");
        Pattern pattern2 = Pattern.compile("a+");
        Pattern pattern3 = Pattern.compile("a?");
        Pattern pattern4 = Pattern.compile("a{2}");
        Pattern pattern5 = Pattern.compile("a{2,}");
        Pattern pattern6 = Pattern.compile("a{2,4}");

        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);
        Matcher matcher4 = pattern4.matcher(text);
        Matcher matcher5 = pattern5.matcher(text);
        Matcher matcher6 = pattern6.matcher(text);

//        while (matcher1.find()) {
//            System.out.println("a* match: " + matcher1.group());
//        }
//        
//        while (matcher2.find()) {
//            System.out.println("a+ match: " + matcher2.group());
//        }
//        
//        while (matcher3.find()) {
//            System.out.println("a? match: " + matcher3.group());
//        }
        
        while (matcher4.find()) {
            System.out.println("a{2} match: " + matcher4.group());
        }
        
        while (matcher5.find()) {
            System.out.println("a{2,} match: " + matcher5.group());
        }
        
        while (matcher6.find()) {
            System.out.println("a{2,4} match: " + matcher6.group());
        }
        
        String text1 = "Hello, world!";
        Pattern pattern = Pattern.compile("world!$");
        Matcher matcher = pattern.matcher(text1);
        if (matcher.find()) {
            System.out.println("Pattern found at the end of the text.");
        }
    }
}
