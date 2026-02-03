import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N;
    private static int[] parent;

    // 1이 루트 노드
    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (visited[next] == false) {
                parent[next] = idx;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int x, y;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
