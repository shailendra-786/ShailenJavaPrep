package leetCode.waterTraoing;

public class p42 {
	static int trap(int[] arr) {
		int countUnit = 0;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {

			int minH = Math.max(0, Math.min(arr[left], arr[right]) - arr[left]);
			int trapWater = arr[right] - minH;
			System.out.println(minH);
			if (arr[left] < arr[right]) {
				left++;
			} else {
				right--;
			}

		}
		return countUnit;
	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}

}
