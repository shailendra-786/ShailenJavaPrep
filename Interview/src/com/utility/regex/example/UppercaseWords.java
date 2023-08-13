package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UppercaseWords {
    public static void main(String[] args) {
        String text = "This is an example of regex usage in Java.";

        String pattern = "\\b(?:is|of|in)\\b";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
        	System.err.println(matcher.group()+" "+result);
            matcher.appendReplacement(result, matcher.group().toUpperCase());
        }
        System.out.println(result);
        matcher.appendTail(result);

        System.out.println("Original: " + text);
        System.out.println("Modified: " + result.toString());
    }
}
