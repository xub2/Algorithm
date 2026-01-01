import java.util.*;
class Solution {

    public long[] solution(int n, long left, long right) {
        
        int len = (int) (right - left + 1); // 5 - 2 = 3
        long[] answer = new long[len];

        int index = 0;

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            answer[index++] = Math.max(row, col) + 1;
        }

        return answer;
        }
}