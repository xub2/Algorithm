import java.util.*;

class Solution {
    // 상 하 좌 우
    private final int[] dirY = {-1, 1, 0, 0};
    private final int[] dirX = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;      // 세로 길이
        int m = maps[0].length(); // 가로 길이
        
        int[] S = null, L = null, E = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char current = maps[i].charAt(j);
                if (current == 'S') S = new int[]{i, j};
                else if (current == 'L') L = new int[]{i, j};
                else if (current == 'E') E = new int[]{i, j};
            }
        }

        int dist1 = bfs(maps, S, L, n, m);
        if (dist1 == -1) return -1;

        int dist2 = bfs(maps, L, E, n, m);
        if (dist2 == -1) return -1;

        return dist1 + dist2;
    }

    private int bfs(String[] maps, int[] start, int[] target, int n, int m) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int time = curr[2];

            if (y == target[0] && x == target[1]) return time;

            for (int i = 0; i < 4; i++) {
                int nY = y + dirY[i];
                int nX = x + dirX[i];

                if (nY >= 0 && nY < n && nX >= 0 && nX < m) {
                    if (maps[nY].charAt(nX) != 'X' && !visited[nY][nX]) {
                        visited[nY][nX] = true;
                        queue.offer(new int[]{nY, nX, time + 1});
                    }
                }
            }
        }
        return -1; 
    }
}