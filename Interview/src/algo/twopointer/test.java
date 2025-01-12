package algo.twopointer;

public class test {
	public static void main(String[] args) {
		String str = "nitin";
		for (int i = 0; i <str.length(); i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				System.out.println("enter");
				break;
			}
		}
		System.out.println("enter not print");

	}
}
