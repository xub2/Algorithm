package dingcorithm.week_5;

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

/**
 * #Cony
 * 시간  0  1  2   3 ...
 * 거리 11 12  15  21 ...
 */

import java.util.*;

public class CatchMe {

    static int c = 11;
    static int b = 2;

    public static Integer catchMe(int conyLoc, int brownLoc) {
        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{brownLoc, 0});

        List<Map<Integer, Boolean>> visited = new ArrayList<>(); // [{},{} .... 20만개]
        for (int i = 0; i < 200001; i++) {
            visited.add(new HashMap<>());
        }

        while (conyLoc <= 200000) {
            conyLoc += time; //
            if (visited.get(conyLoc).containsKey(time)) {// get으로 가져오는건 map -> map에 해당 키가 있으면 해당 키값 초에 브라운이 value 번 위치에 있었음
                return time; // 있다면 time 반환
            }

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) { // 현재 시간 기준으로만 queue 를 뽑고 싶음
                int[] current = queue.poll(); // [brown_loc(2), 0]
                int currentPosition = current[0]; //2
                int currentTime = current[1];//0

                int newTime = currentTime + 1; // 1초 지남

                int newPosition = currentPosition - 1; // 첫번째 이동 조건
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);
                    queue.add(new int[]{newPosition, newTime}); // brown_loc(2) - 1, 1
                }

                newPosition = currentPosition + 1; // 두번째 이동 조건
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);
                    queue.add(new int[]{newPosition, newTime}); // brown_loc(2) + 1, 1
                }

                newPosition = currentPosition * 2; // 세번째 이동 조건
                if (0 <= newPosition && newPosition <= 200000) {
                    visited.get(newPosition).put(newTime, true);  // visited[new_position][new_time]
                    queue.add(new int[]{newPosition, newTime});  // brown_loc(2) * 2, 1
                }
            }

            time += 1;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(catchMe(c, b));  // 5가 나와야 합니다!

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
    }

}
