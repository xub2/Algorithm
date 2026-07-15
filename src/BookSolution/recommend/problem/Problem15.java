package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

// 요세푸스 문제
public class Problem15 {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println(solution(n,k));
    }

    private static int solution(int n, int k) {

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) { // k - 1 만큼의 사람은 뽑아서 앞에 넣기
                queue.offer(queue.poll());
            }
            // k 번째 사람은 제거
            queue.poll();
        }

        return queue.poll();
    }

}
