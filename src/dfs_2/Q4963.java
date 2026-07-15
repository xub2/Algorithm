package dfs_2;

import java.util.*;
import java.io.*;

public class Q4963 {

    private static final int MAX = 50 + 10;

    private static boolean[][] graph;
    private static boolean[][] visited;

    private static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int W, H;

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < dirY.length; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (graph[nextY][nextX] && !visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (H == 0 && W == 0) {
                break;
            }

            graph = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= W; j++) {
                    int temp = Integer.parseInt(st.nextToken());

                    if (temp == 1) {
                        graph[i][j] = true;
                    }
                }

            }

            int count = 0;
            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    if (graph[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        // dfs가 한번 돌면 하나의 섬이다. -> count++
                        count++;
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
