package BookSolution.recommend.array;

import java.util.*;

public class Recommend2 {

    public int[] solution(int[] numbers) {

        int[] result = new int[numbers.length];
        int a = numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            result[a - i - 1] = numbers[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Recommend2 recommend2 = new Recommend2();
        System.out.println(Arrays.toString(recommend2.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(recommend2.solution(new int[]{1, 1, 1, 1, 1, 2})));
        System.out.println(Arrays.toString(recommend2.solution(new int[]{1, 0, 1, 1, 1, 3, 5})));
    }
}
