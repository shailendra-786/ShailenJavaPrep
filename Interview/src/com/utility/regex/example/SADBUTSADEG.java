package com.utility.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.utility.regex.RegexExpression;

public class SADBUTSADEG {
	public static void main(String[] args) {
		String str = "sadbutsadherewehaveonemoresadCaeInsensitiveSAD";
		Pattern p = Pattern.compile(RegexExpression.SAD_BUT_SAD_EG); //"(?i)(sad)";
		Matcher m = p.matcher(str);
		while(m.find()) {
			System.out.println(m.start()+" "+m.end());
		}

	}
}
