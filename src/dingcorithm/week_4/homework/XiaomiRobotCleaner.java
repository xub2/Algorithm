package dingcorithm.week_4.homework;

import java.util.*;

public class XiaomiRobotCleaner {

    private static int currentR = 7;
    private static int currentC = 4;
    private static int currentD = 0;
    private static int[][] currentRoomMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    // (북0 동1 남2 서3)
    private static int[] rCompass = {-1, 0, 1, 0};
    private static int[] cCompass = {0, 1, 0, -1};

    private static int getDIndexWhenRotateToLeft(int d) {
        return (d + 3) % 4;
    }

    public static int getDIndexWhenGoBack(int d) {
        return (d + 2) % 4;
    }

    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {
        int n = roomMap.length; // 11
        int m = roomMap[0].length; // 10
        int countOfDepartmentsCleaned = 1; // 최초 구역 청소하고 시작

        roomMap[r][c] = 2; // 청소를 한 구역은 2로 표시

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c, d}); // 루트노드

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            r = current[0];
            c = current[1];
            d = current[2];
            int tempD = d;

            for (int i = 0; i < 4; i++) {
                tempD = getDIndexWhenRotateToLeft(tempD); // 3 서 (왼쪽)
                int newR = r + rCompass[tempD];
                int newC = c + cCompass[tempD];

                // 왼쪽에 청소할 공간이 있으면 그 방향으로 회전 + 한칸 전진 + 1번부터 진행
                if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] == 0) {
                    countOfDepartmentsCleaned += 1;
                    roomMap[newR][newC] = 2;
                    queue.offer(new int[]{newR, newC, tempD});
                    break;
                } else if (i == 3) { //(i = 3 -> 네 방향 모두 본 후) 네 방향 모두 청소가 되어 있거나 벽인 경우 바라보는 방향 유지 + 한칸 후진 + 2번 진행
                    tempD = getDIndexWhenGoBack(d);
                    newR = r + rCompass[tempD];
                    newC = c + cCompass[tempD];

                    //네 방향 모두 청소가 되어 있거나 벽이면서 뒤쪽도 벽이라 후진 불가시 종료
                    if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] != 1) {
                        queue.offer(new int[]{newR, newC, d});
                    } else {
                        return countOfDepartmentsCleaned;
                    }
                }
            }
        }

        return countOfDepartmentsCleaned;

    }

    public static void main(String[] args) {
        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));
    }

}
