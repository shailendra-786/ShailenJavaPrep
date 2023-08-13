package stack.backtrack;

class SingleTonClass {
	private static SingleTonClass obj = null;

	private SingleTonClass() {

	}

	public static SingleTonClass getObject() {
		if (obj == null) {
			obj = new SingleTonClass();
		}
		return obj;
	}

	public int getShortestLenOfString(String[] arr) {
		int len = arr[0].length();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length() < len) {
				len = arr[i].length();
			}
		}

		return len;
	}
}

public class LongestPrefixAndSingleTon {
	public static void main(String[] args) {
		SingleTonClass obj = SingleTonClass.getObject();
		System.out.println(SingleTonClass.getObject().hashCode());
		String longestPrefix = "";
		String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		int i = obj.getShortestLenOfString(arr);
		System.out.println(i);
		String shortestPrefix = arr[0];
		for (int j = 1; j < arr.length; j++) {

			for (int k = 0; k < i; k++) {
				if (arr[j-1].charAt(k) != arr[j].charAt(k)) {
					String current = arr[j].substring(0,k);
					if(shortestPrefix.length()> current.length()) {
						shortestPrefix = current;
					}
				}
			}
		

		}
		System.out.println(shortestPrefix);
	}
}
