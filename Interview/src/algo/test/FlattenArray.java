package algo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenArray {

    public static void main(String[] args) {
        Integer[] nestedArr = new Integer[]{1, new Integer[]{2, new Integer[]{3, new Integer[]{4}}, 5}};

        List<Integer> flatList = Arrays.stream(nestedArr)
                .flatMap(FlattenArray::flatten)
                .collect(Collectors.toList());

        System.out.println(flatList); // Output: [1, 2, 3, 4, 5]
    }

    private static Stream<Integer> flatten(Integer[] arr) {
        List<Integer> flatList = new ArrayList<>();
        for (Integer i : arr) {
            if (i instanceof Integer[]) {
                flatList.addAll(Arrays.asList(flatten((Integer[]) i).toArray(Integer[]::new)));
            } else {
                flatList.add(i);
            }
        }
        return flatList.stream();
    }
}
