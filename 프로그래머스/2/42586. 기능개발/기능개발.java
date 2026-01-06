import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();

        int[] canDeployDate = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            canDeployDate[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        // 첫번째 작업이 끝나는 날 기준
        // 그 뒤에 작업들이 끝나는 날 < 첫번 째 작업이 끝나는 날 == 첫번째 작업이 끝나 배포할 때 같이 배포할 수 있음

        // 그 외에는
        int maxDay = canDeployDate[0]; // 1번 작업이 완료되어야 함

        for (int i = 0; i < progresses.length; i++) {
            if (canDeployDate[i] <= maxDay) { // 9 <= 7
                count++;
            } else {
                queue.add(count); // 현재까지의 카운트 추가 (배포 가능 프로세스 개수)
                count = 1; // 카운트 1로 초기화 (9일)
                maxDay = canDeployDate[i];
            }
        }

        queue.add(count);
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}