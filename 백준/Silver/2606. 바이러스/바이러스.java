import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] graph;
    private static boolean[] visited;
    private static int N,M;
    private static int answer;

    private static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 0; i <= N; i++) {
            if (visited[i] == false && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 1. 그래프 채우기
        int x;
        int y;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. 재귀 호출
        dfs(1);

        // 3. 출력
        bw.write(String.valueOf(answer - 1));
        br.close();
        bw.close();
    }
}