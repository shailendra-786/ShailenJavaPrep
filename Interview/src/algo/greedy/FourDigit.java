package algo.greedy;
//Leettcode Q 1221
public class FourDigit {

	public static void main(String[] args) {
		String s = "RLRRLLRLRL";
		System.out.println(balancedStringSplit(s));

	}
	
	public static int balancedStringSplit(String s) {
	    int count = 0;
	    int lCount = 0;
	    int rCount = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == 'L') {
	            lCount++;
	        } else if (s.charAt(i) == 'R') {
	            rCount++;
	        }
	        if (lCount == rCount) {
	            count++;
	            lCount = 0;
	            rCount = 0;
	        }
	    }
	    return count;
	}



}
