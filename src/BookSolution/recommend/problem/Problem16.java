package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Problem16 {

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

        int[] daysLeft = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        int mustDeployed = daysLeft[0]; // 7

        for (int i = 0; i < progresses.length; i++) {
            if (daysLeft[i] <= mustDeployed) {
                count++;
            } else {
                queue.offer(count);
                count = 1;
                mustDeployed = daysLeft[i];
            }
        }

        queue.offer(count);

        return queue.stream().mapToInt(integer -> integer.intValue()).toArray();
    }

}
