package dfs_2;

import java.io.*;
import java.util.StringTokenizer;

public class Q13565 {

    private static final int MAX = 1000 + 10;

    private static boolean[][] map;
    private static boolean[][] visited;

    private static int M, N;
    private static String answer;

    private static final int[] dirY = {1, -1, 0, 0};
    private static final int[] dirX = {0, 0, -1, 1};

    private static void dfs(int y, int x) {
        if (answer.equals("YES")) return;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (!visited[nextY][nextX] && map[nextY][nextX]) {
                if (nextY == M) {
                    answer = "YES";
                    return; // 메인으로 가는게 아니라 얘를 호출 한 곳으로 돌아김
                }

                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];
        answer = "NO";

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), "");

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    map[i + 1][j + 1] = true;
                } else {
                    map[i + 1][j + 1] = false;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (answer.equals("YES")) {
                break;
            }
            dfs(1, i);
        }

        bw.write(answer);

        br.close();
        bw.close();
    }
}
