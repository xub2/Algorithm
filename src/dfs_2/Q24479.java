package dfs_2;

import java.util.*;
import java.io.*;

/**
 * dfs(V,E,R)
 * V : 정점 집합
 * E : 간선 집합
 * R : 시작 정점
 * R 에서 시작하여 DFS 진행시 노드 방문 순서 출력
 */
public class Q24479 {

    private final static int MAX = 100000 + 10;

    // 리스트를 담을 배열 !!
    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static int V, E, R;

    private static int[] answer;
    private static int order;

    private static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = order;
        order++;

        for (int i = 0; i < graph[idx].size(); i++) {
            if (!visited[graph[idx].get(i)]) {
                dfs(graph[idx].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= V; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= V; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
