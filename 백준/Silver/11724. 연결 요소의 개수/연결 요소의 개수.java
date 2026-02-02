import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final static int MAX = 1000 + 10;
    private static boolean[][] graph;
    private static boolean[] visited;
    private static int N;
    private static int M;
    private static int answer;

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 그래프 채우기
        int u,v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();

    }
}