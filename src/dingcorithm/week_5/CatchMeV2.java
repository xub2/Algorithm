package dingcorithm.week_5;

import java.util.*;

/**
 * Q. 연인 코니와 브라운은 광활한 들판에서 ‘나 잡아 봐라’ 게임을 한다.
 * 이 게임은 브라운이 코니를 잡거나, 코니가 너무 멀리 달아나면 끝난다.
 * 게임이 끝나는데 걸리는 최소 시간을 구하시오.
 *
 * 조건은 다음과 같다.
 * 코니는 처음 위치 C에서 1초 후 1만큼 움직이고,
 * 이후에는 가속이 붙어 매 초마다 이전 이동 거리 + 1만큼 움직인다.
 * 즉 시간에 따른 코니의 위치는 C, C + 1, C + 3, C + 6, …이다.
 *
 * 브라운은 현재 위치 B에서 다음 순간 B – 1, B + 1, 2 * B 중 하나로 움직일 수 있다.
 * 코니와 브라운의 위치 p는 조건 0 <= x <= 200,000을 만족한다.
 * 브라운은 범위를 벗어나는 위치로는 이동할 수 없고, 코니가 범위를 벗어나면 게임이 끝난다
 * c = 11 # 코니의 처음 위치
 * b = 2  # 브라운의 처음 위치
 */

public class CatchMeV2 {

    static int c = 11;
    static int b = 2;

    public static void main(String[] args) {
        System.out.println(catchMe(c, b));  // 5가 나와야 합니다!

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
    }

    private static Integer catchMe(int conyLocation, int brownLocation) {
        int time = 0; // 시작 시간

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{brownLocation, 0}); // B = 2 -> {위치 : 2, 시간 : 0}

        List<Map<Integer, Boolean>> visited = new ArrayList<>();
        for (int i = 0; i < 200001; i++) {
            visited.add(new HashMap<>());
        }

        while (conyLocation <= 200000) {
            conyLocation += time;
            if (visited.get(conyLocation).containsKey(time)) {
                return time; // 해당 시간이 가장 최소
            }
            
            // 못 잡았다면 브라운 추격 시작

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int[] current = queue.poll(); //[2,0]
                int currentPosition = current[0]; // 2
                int currentTime = current[1]; // 0

                int newTime = currentTime + 1;

                int newPosition = currentPosition - 1;
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);
                    queue.offer(new int[]{newPosition, newTime});
                }

                newPosition = currentPosition + 1;
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);
                    queue.offer(new int[]{newPosition, newTime});
                }

                newPosition = currentPosition * 2;
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);
                    queue.offer(new int[]{newPosition, newTime});
                }
            }

            time += 1;
        }
        return null;
    }
}
