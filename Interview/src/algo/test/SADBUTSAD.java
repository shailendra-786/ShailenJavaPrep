package algo.test;

public class SADBUTSAD {

	public static void main1(String[] args) {
		String str = "sadbutsad";
		String substring = "sad";
		for(int i=0;i<str.length() && substring.length()<str.length()+1-i;i++) {
			String newstr=str.substring(i, substring.length()+i);
			if(substring.equals(newstr)) {
				System.out.println(i);
				i = substring.length()+i;
			}
		}
		
		  
//	    for (int i = 0; i <= length - substringLength; i++) {
//	        String newStr = str.substring(i, i + substringLength);
//	        if (substring.equals(newStr)) {
//	            System.out.println(i);
//	            i += substringLength - 1;
//	        }
//	    }
	}
	
	public static void main(String[] args) {
	    String str = "sadbutsad";
	    String substring = "sad";

	    int i = 0;
	    while (i <= str.length() - substring.length()) {
	        if (str.startsWith(substring, i)) {
	            System.out.println(i);
	            i += substring.length();
	        } else {
	            i++;
	        }
	    }
	}


}
