package dfs_2;

import java.io.*;
import java.util.*;

public class Q16173 {

    private static final String WIN = "HaruHaru";
    private static final String DEFEAT = "HING";
    private static final int MAX = 3 + 110;

    private static int[][] map;
    private static boolean[][] visited;

    // 우 하
    private static final int[] dirY = {1, 0};
    private static final int[] dirX = {0, 1};

    private static int N;

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        if (y == N && x == N) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newY = y + dirY[i] * map[y][x];
            int newX = x + dirX[i] * map[y][x];

            if (!visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        if (visited[N][N]) {
            bw.write(WIN);
        } else {
            bw.write(DEFEAT);
        }

        bw.close();
        br.close();
    }

}
