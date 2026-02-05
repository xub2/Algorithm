import java.io.*;
import java.util.*;

public class Main {

    private final static int MAX = 50 + 10;

    private static boolean map[][];
    private static boolean visited[][];

    private static int W;
    private static int H;

    // 좌상 상 우상 좌하 하 우하 좌 우
    private static int[] dirY = {-1, -1, -1, 1, 1, 1, 0, 0};
    private static int[] dirX = {-1, 0, 1, -1, 0, 1, -1, 1};

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (map[newY][newX] && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= W; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        map[i][j] = true;
                    }
                }
            }

            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    if (map[i][j] && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
