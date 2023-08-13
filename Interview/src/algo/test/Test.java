package algo.test;

// drawback only work on single digit 
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,7,8,10,8};
		Arrays.sort(arr);
		
//		String str = Arrays.toString(arr);
//		str = str.replaceAll("\\[|\\]|,|\\s", "");  // best way
//		str = str.replace("[", "").replace("]", "").replace(",", "").replaceAll(" ", "");// not okay
		String str = String.join("", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)); // okay
		System.out.println(str);
		System.out.println(str.indexOf("2"));		
		System.out.println(str.lastIndexOf("2"));		
	}

}
