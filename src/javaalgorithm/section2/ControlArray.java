package javaalgorithm.section2;

import java.util.Arrays;
import java.util.Comparator;

public class ControlArray {

    public static void main(String[] args){

        int[] input1 = {4, 2, 2, 1, 3, 4};
        int[] input2 = {2, 1, 1, 3, 2, 5, 4};

        System.out.println(Arrays.toString(solution(input1)));
        System.out.println(Arrays.toString(solution(input2)));
    }

    private static int[] solution(int[] arr){
        // 배열 중복 값 제거, 내림차순

        Integer[] result = Arrays.stream(arr)
                .boxed()
                .distinct()
                .toArray(value -> new Integer[value]);

        Arrays.sort(result, Comparator.reverseOrder());

        return Arrays.stream(result).mapToInt(integer -> integer.intValue()).toArray();
    }

}
