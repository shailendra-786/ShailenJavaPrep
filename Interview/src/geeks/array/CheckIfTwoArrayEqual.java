package geeks.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfTwoArrayEqual {

	public static void main(String[] args) {
		Integer A[] = {1,2,5,4,0};
		Integer B[] = {2,4,5,0,1};
		Set<Integer> aSet = new HashSet<>(Arrays.asList(A));
		Set<Integer> bSet = new HashSet<>(Arrays.asList(B));
		aSet.removeAll(bSet);
		System.out.println(aSet);
	}

}
