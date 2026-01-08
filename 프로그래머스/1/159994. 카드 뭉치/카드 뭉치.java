import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
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
                return "No";
            }
        }

        return "Yes";
    }
}