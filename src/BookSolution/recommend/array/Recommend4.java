package BookSolution.recommend.array;

import java.util.*;

public class Recommend4 {

    public int[] solution(int[] arr, int divisor) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                resultList.add(arr[i]);
            }
        }

        if (resultList.isEmpty()) {
            resultList.add(-1);
        }


        return resultList.stream()
                .mapToInt(integer -> integer.intValue())
                .sorted()
                .toArray();
    }

    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(value -> value % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) {
            answer = new int[]{-1};
        }

        return answer;
    }


    public static void main(String[] args) {
        Recommend4 recommend4 = new Recommend4();
        System.out.println(Arrays.toString(recommend4.solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(recommend4.solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(recommend4.solution(new int[]{3, 2, 6}, 10)));

        System.out.println();
        System.out.println(Arrays.toString(recommend4.solution2(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(recommend4.solution2(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(recommend4.solution2(new int[]{3, 2, 6}, 10)));



    }

}
