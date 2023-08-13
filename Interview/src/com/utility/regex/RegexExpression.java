package com.utility.regex;

public class RegexExpression {
	final static public String FIXED_GROUP = "(abc)"; // () : "(abc)+" matches "abc", "abcabc", "abcabcabc", etc.

	final static public String FIXED_GROUP_WITH_PLUS = "(abc)+"; // () : "(abc)+" matches "abc", "abcabc", "abcabcabc",
																	// etc.

	final static public String EITHER_ABC_OR_DC = "(abc)|(dc)"; // | : "apple|orange" matches "apple" or "orange".

	final static public String EITHER_ABC_OR_DC_WITH_PLUS = "(abc)|(dc)"; // | + : "apple|orange" matches "apple" or
																			// "orange".

	final static public String EXACT_MATCH_OF_WORD = "\\bmn\\b"; // \b : "\bword\b" matches "word" as a whole word, not
																	// within another word.

	final static public String SINGLE_SPACE = "\\s";

	final static public String EVERY_SPACE = "\\s+";

	final static public String SINGLE_DIGIT = "\\d";

	final static public String EACH_DIGIT = "\\d+";
	
	// TO USE NEGATION (^) WE HAVE KEEP OUT EXPRESSION INTO THE [^] THEN IT WILL
	// WORK OTHERWISE NOT.
	final static public String ANY_CHARACTER = "(?i)[a-z]";

	final static public String VOWELS = "(?i)[aieou]";

	final static public String VOWELS_AND_SPACE = "(?i)[\\d\\saeiou]+";

	final static public String SPACE_AND_DIGIT = "\\s|\\d";

	final static public String NEGATE_SPACE_AND_DIGIT = "[^\\s|^\\d]";
	final static public String REMOVE_CHAR_ONLY = "[^\\d]";
	final static public String SAD_BUT_SAD_EG = "(?i)(sad)";
	
	

}
