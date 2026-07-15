package dfs_2;

import java.util.*;
import java.io.*;

public class Q11725 {

    private static final int MAX = 100000 + 10;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static int N;

    private static int[] answer;

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (!visited[next]) {
                answer[next] = idx;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= N ; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();

    }


}
