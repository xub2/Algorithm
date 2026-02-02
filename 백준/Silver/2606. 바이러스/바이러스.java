import java.util.*;
import java.io.*;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N,M; // 노드 개수 N , 간선 개수 M
    private static int count;

    private static void dfs(int index) {
        visited[index] = true;

        for (int i = 0; i < graph[index].size(); i++) {
            int next = graph[index].get(i);

            if(visited[next] == false){ // 방문하지 않고, 간선이 있어야
                count++;
                dfs(graph[index].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 노드 개수
        M = Integer.parseInt(br.readLine()); // 긴선 개수

        // 1. 그래프 구현
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = 0;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x , y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }

}
