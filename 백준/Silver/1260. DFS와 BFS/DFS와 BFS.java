import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N, M, V;
    private static BufferedWriter bw;

    private static void dfs(int idx) throws IOException {
        // 1. 방문 처리
        visited[idx] = true;
        bw.write(idx + " ");

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (visited[next] == false) {
                dfs(next);
            }
        }

    }

    private static void bfs(int idx) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            bw.write(polled + " ");

            for (int i = 0; i < graph[polled].size(); i++) {
                int next = graph[polled].get(i);

                if (visited[next] == false) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 노드수 M 간선수 V 시작 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        
        for (int i = 0 ; i < graph.length; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);
        bw.flush();

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        bw.newLine();

        bfs(V);
        bw.flush();

        br.close();
        bw.close();

    }
}
