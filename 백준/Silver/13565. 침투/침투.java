import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int M, N;
    private static boolean[][] map;
    private static boolean[][] visited;

    private static boolean isSuccess = false;

    private static final int MAX = 1000 + 10;

    // 상 하 좌 우
    private static int[] dirY = {-1, 1, 0, 0};
    private static int[] dirX = {0, 0, -1, 1};


    private static void dfs(int y, int x) {

        if (y == M) {
            isSuccess = true;
        }

        visited[y][x] = true;

        for (int i = 0; i < dirY.length; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (map[nextY][nextX] && !visited[nextY][nextX]) {
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

        for (int i = 1; i <= M; i++) {
            String line = br.readLine();

            for (int j = 1; j <= N; j++) {
                if (line.charAt(j - 1) == '0') {
                    map[i][j] = true;
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            if (map[1][j] == true && visited[1][j] == false) {
                dfs(1, j);
            }
        }

        if (isSuccess) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }

}
