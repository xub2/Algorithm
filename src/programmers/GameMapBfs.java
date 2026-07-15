package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameMapBfs {

    final int MAX = 100 + 10;

    boolean[][] graph;
    boolean[][] visited;
    int answer = -1;

    int targetY;
    int targetX;

    // 상 하 좌 우
    final int[] dirY = {-1, 1, 0, 0};
    final int[] dirX = {0, 0, -1, 1};

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

        targetY = maps.length;
        targetX = maps[0].length;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 1) {
                    graph[i + 1][j + 1] = true;
                }
            }
        }

        bfs(1, 1, 1, targetY, targetX);

        return answer;
    }

    public static void main(String[] args) {

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        GameMapBfs gameMapBfs = new GameMapBfs();
        System.out.println(gameMapBfs.solution(maps));
    }
}
