package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem17 {

    public static void main(String[] args) {
        String[] goal = new String[]{"i", "want", "to", "drink", "water"};

        String[] cards1Correct = new String[]{"i", "drink", "water"};
        String[] cards2Correct = new String[]{"want", "to"};

        String[] cards1Wrong = new String[]{"i", "water", "drink"};
        String[] cards2Wrong = new String[]{"want", "to"};

        System.out.println(solution(cards1Correct, cards2Correct, goal));
        System.out.println(solution(cards1Wrong, cards2Wrong, goal));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        // 큐 투 배럭
        Deque<String> card1Queue = new ArrayDeque<>();
        Deque<String> card2Queue = new ArrayDeque<>();

        for (String s : cards1) {
            card1Queue.offer(s);
        }

        for (String s : cards2) {
            card2Queue.offer(s);
        }

        for (String word : goal) {
            if (!card1Queue.isEmpty() && card1Queue.peek().equals(word)) {
                card1Queue.poll();
            } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(word)) {
                card2Queue.poll();
            } else {
                return "NO";
            }
        }

        return "YES";

    }
}
