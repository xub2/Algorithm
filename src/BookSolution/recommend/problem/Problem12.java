package BookSolution.recommend.problem;

import java.util.*;

// 주식 가격
public class Problem12 {

    public static void main(String[] args){

        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    private static int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // 인덱스 푸시

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices.length - 1 - pop;
        }

        return result;

    }

}
