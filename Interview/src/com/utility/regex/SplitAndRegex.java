package com.utility.regex;

import java.util.Arrays;

public class SplitAndRegex {
	public static void main(String[] args) {
		// start of special case
		String sentence = "10 mn. amns";
		System.out.println(sentence.replaceAll("mn", "kunal"));
		System.out.println(sentence.replaceAll(RegexExpression.EXACT_MATCH_OF_WORD, "kunal"));
		// end of special case

		// []
		String commonString = "12abcabcdc  234 abc4t dcdc4";
		String[] strArr1 = commonString.split(RegexExpression.FIXED_GROUP);
		System.out.println(Arrays.toString(strArr1));

		String[] strArrPLUS1 = commonString.split(RegexExpression.FIXED_GROUP_WITH_PLUS);
		System.out.println(Arrays.toString(strArrPLUS1));

		String[] strArrEitherOr = commonString.split(RegexExpression.EITHER_ABC_OR_DC);
		System.out.println(Arrays.toString(strArrEitherOr));

		String[] strArrEitherOrWithPlus = commonString.split(RegexExpression.EITHER_ABC_OR_DC_WITH_PLUS);
		System.out.println(Arrays.toString(strArrEitherOrWithPlus));
		
		String[] strArrSingleSpace = commonString.split(RegexExpression.SINGLE_SPACE);
		System.out.println(Arrays.toString(strArrSingleSpace));
		
		String[] strArrAllSpace = commonString.split(RegexExpression.EVERY_SPACE);
		System.out.println(Arrays.toString(strArrAllSpace));
		
		String[] strArrDigit = commonString.split(RegexExpression.SINGLE_DIGIT);
		System.out.println(Arrays.toString(strArrDigit));
		
		String[] strArrAllDigit = commonString.split(RegexExpression.EACH_DIGIT);
		System.out.println(Arrays.toString(strArrAllDigit));
		
		String sentenceVowels = "here we123 gO";
		System.out.println(sentenceVowels.replaceAll(RegexExpression.VOWELS, ""));
		System.out.println(Arrays.toString(sentenceVowels.split(RegexExpression.VOWELS)));
		
		System.out.println(Arrays.toString(commonString.split(RegexExpression.ANY_CHARACTER)));
		
		
		

	}
}
