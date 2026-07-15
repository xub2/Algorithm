package BookSolution.recommend.array;

import java.util.Arrays;

public class Recommend3 {

    public long[] solution(int n, long left, long right) { // 2 5

        int len = (int) (right - left + 1); // 5 - 2 = 3
        long[] answer = new long[len]; //4

        int index = 0;

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            answer[index++] = Math.max(row, col) + 1;
        }

        return answer;
    }


    public static void main(String[] args) {
        Recommend3 recommend3 = new Recommend3();
        System.out.println(Arrays.toString(recommend3.solution(3, 2, 5)));
//        System.out.println(Arrays.toString(recommend3.solution(4, 7, 14)));
    }

}
