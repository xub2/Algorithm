package dfs_2;

import java.io.*;
import java.util.StringTokenizer;

public class Q1012 {

    private static final int MAX = 50 + 10;

    private static boolean[][] map;
    private static boolean[][] visited;

    private static int T, N, M, K;

    private static final int[] dirY = new int[]{1, -1, 0, 0};
    private static final int[] dirX = new int[]{0, 0, -1, 1};

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (nextY >= 1 && nextY <= N && nextX >= 1 && nextX <= M
                    && map[nextY][nextX] && !visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y + 1][x + 1] = true; // 왜 Y 부터
            }

            int answer = 0;
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++)
                    if (map[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
