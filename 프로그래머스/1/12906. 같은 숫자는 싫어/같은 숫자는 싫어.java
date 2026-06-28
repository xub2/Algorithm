import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.offerLast(num);
            }
        }

        return deque.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}