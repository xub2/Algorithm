import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] map;
    private static boolean[][] visited;
    private static int T;
    private static int N; // 세로
    private static int M; // 가로
    private static int K; // 배추 개수

    private static int dirY[] = {1, -1, 0, 0};
    private static int dirX[] = {0, 0, 1, -1};

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (newY >= 1 && newY <= N && newX >= 1 && newX <= M){
                if (map[newY][newX] == true && visited[newY][newX] == false) {
                    dfs(newY, newX);
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y + 1][x + 1] = true;
            }

            // 여기서 DFS 수행해야 함
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == true && visited[i][j] == false) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
            T--;
        }

        br.close();
        bw.close();
    }
}
