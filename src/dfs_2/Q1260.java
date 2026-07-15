package dfs_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {

    private static int N, M, V;

    private final static int MAX = 1000 + 10;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static Deque<Integer> queue;

    private static void dfs(int idx) {
        System.out.print(idx + " ");
        visited[idx] = true;

        for (int next : graph[idx]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs() {
        queue = new ArrayDeque<>();
        visited = new boolean[MAX];

        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");

            for (int i : graph[idx]) { // 나와 연결 된 모든 노드에 대해 방문 처리 + 큐에 입력
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        System.out.println();
        bfs();
    }


}
