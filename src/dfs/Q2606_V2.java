package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606_V2 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N, M;
    private static int count;

    private static void dfs(int index) {
        // 1. 방문처리
        visited[index] = true;

        for (int i = 0; i < graph[index].size(); i++) {
            int next = graph[index].get(i);

            if (visited[next] == false) {
                count++;
                dfs(next);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 정보 Init
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = 0;

        // 2. 리스트 채우기
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        bw.write(String.valueOf(count));
        bw.close();
        br.close();

    }
}
