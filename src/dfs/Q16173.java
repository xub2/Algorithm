package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Q16173 {

    private final static int MAX = 3 + 100 + 10;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dirY = {1, 0};
    private static int[] dirX = {0, 1};

    private static int N;

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        if (y == N && x == N) {
            return;
        }

        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i] * map[y][x];
            int newX = x + dirX[i] * map[y][x];

            if (visited[newY][newX] == false) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
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

        if (visited[N][N] == true) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }

        br.close();
        bw.close();
    }
}
