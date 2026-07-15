package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24479 {

    private static int N, M, R;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] order;
    private static int count;

    private static void dfs(int idx) {
        visited[idx] = true;
        order[idx] = count;
        count++;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if(visited[next] == false){
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        R = Integer.parseInt(st.nextToken()); // 시작 노드

        visited = new boolean[N + 1];
        order = new int[N + 1];
        count = 1;

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 오름차순 정렬
        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(order[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
