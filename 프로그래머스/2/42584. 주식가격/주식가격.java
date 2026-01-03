import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
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