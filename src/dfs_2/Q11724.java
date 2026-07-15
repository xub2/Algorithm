package dfs_2;

import java.io.*;
import java.util.StringTokenizer;

public class Q11724 {

    final static int MAX = 1000 + 10;

    private static boolean[][] graph;
    private static boolean[] visited;

    private static int N, M;
    private static int answer;

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i < graph[idx].length; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();


    }
}
