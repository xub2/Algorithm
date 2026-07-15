package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724WithArray {

    private final static int MAX = 1000 + 10;

    private static boolean[][] graph;
    private static boolean[] visited;
    private static int N,M;
    private static int answer = 0;

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs 호출
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        // 3. 결과 출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();

    }
}
