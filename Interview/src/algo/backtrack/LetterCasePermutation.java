package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		String str = "1a2b";
		letterCasePermutation(str).stream().forEach(System.out::println);
		
	}
	
	public static List<String> letterCasePermutation(String s) {
	    List<String> output = new ArrayList<>();
	    backtrack(s, 0, new StringBuilder(), output);
	    return output;
	}

	private static void backtrack(String s, int index, StringBuilder current, List<String> output) {
	    if (current.length() == s.length()) {
	        output.add(current.toString());
	        return;
	    }
	    
	    char c = s.charAt(index);
	    if (Character.isLetter(c)) {
	        backtrack(s, index + 1, current.append(Character.toLowerCase(c)), output);
	        current.deleteCharAt(current.length() - 1);
	        backtrack(s, index + 1, current.append(Character.toUpperCase(c)), output);
	        current.deleteCharAt(current.length() - 1);
	    } else {
	        backtrack(s, index + 1, current.append(c), output);
	        current.deleteCharAt(current.length() - 1);
	    }
	}


}
