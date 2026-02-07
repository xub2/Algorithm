import java.util.*;

class Solution {
    final int MAX = 100 + 10;

    boolean[][] graph;
    boolean[][] visited;
    int answer = -1;

    // 상 하 좌 우
    int[] dirY = {-1, 1, 0, 0};
    int[] dirX = {0, 0, -1, 1};

    public void bfs(int y, int x, int count, int targetY, int targetX) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x, count});
        visited[y][x] = true;


        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int pollY = polled[0];
            int pollX = polled[1];
            int curDist = polled[2];

            if (pollY == targetY && pollX == targetX) {
                this.answer = curDist;
                return;
            }

            for (int i = 0; i < dirY.length; i++) {
                int newY = pollY + dirY[i];
                int newX = pollX + dirX[i];

                if (graph[newY][newX] && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.offer(new int[]{newY, newX, curDist + 1});
                }
            }

        }

    }

    public int solution(int[][] maps) {

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 1) {
                    graph[i + 1][j + 1] = true;
                }
            }
        }

        bfs(1, 1, 1, maps.length, maps[0].length);

        return answer;
    }
}