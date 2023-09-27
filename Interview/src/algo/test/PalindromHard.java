package algo.test;
//1147. Longest Chunked Palindrome Decomposition
public class PalindromHard {

	public static void main(String[] args) {
//		String text = "antaprezatepzapreanta";
		String text = "ghiabcdefhelloadamhelloabcdefghi";
		int len = text.length();
		int j = len-1;
		boolean isTrue=true;
		int count =0;
		for (int i = 0; i < len / 2;) {
			while(isTrue){
				if(text.charAt(i)==text.charAt(j)) {
					System.out.println(text.substring(j,len-i));
					isTrue=!isTrue;
					i=count+1;
					break;
				}
				j--;
				count++;
			}
			isTrue=!isTrue;

		}

	}
	
	
	public int longestDecomposition(String text) {
        int n = text.length();
        int left = 0;
        int right = n - 1;
        int count = 0;
        String leftStr = "";
        String rightStr = "";

        while (left <= right) {
            leftStr = leftStr + text.charAt(left);
            rightStr = text.charAt(right) + rightStr;

            if (leftStr.equals(rightStr)) {
                count += 2;
                leftStr = "";
                rightStr = "";
            }

            left++;
            right--;
        }

        if (!leftStr.equals("") || !rightStr.equals("")) {
            count++;
        }

        return count;
    }

    public static void main1(String[] args) {
        PalindromHard solution = new PalindromHard();
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int longestDecompositionLength = solution.longestDecomposition(text);
        System.out.println("Longest Chunked Palindrome Decomposition Length: " + longestDecompositionLength);
    }

}
