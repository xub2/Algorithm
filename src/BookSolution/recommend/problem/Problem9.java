package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

// 10 진수를 2진수로 변환하기
public class Problem9 {

    public static void main(String[] args) {

        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }

    private static String solution(int decimal) {

        Deque<Integer> stack = new ArrayDeque<>();

        while (decimal > 0) {
            int reminder = decimal % 2;
            stack.push(reminder);

            decimal = decimal / 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
