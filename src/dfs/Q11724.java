package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N,M;
    private static int count = 0;

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (visited[next] == false) {
                dfs(next);
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
        visited = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int x,y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. dfs 실행
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                dfs(i);
                count++;
            }
        }

        // 3. 결과 출력
        bw.write(String.valueOf(count));

        br.close();
        bw.close();

    }
}
