package javaalgorithm.section8;

import java.io.*;

public class Q6 {

    private static int N;
    private static boolean[] graph;

    private static void dfs(int L) throws Exception {
        if (L == N + 1) {

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < graph.length; i++) {
                if (graph[i]) {
                    sb.append(i).append(" ");
                }
            }

            if (!sb.isEmpty()) {
                System.out.println(sb.toString());
            }

        } else {
            graph[L] = true;
            dfs(L + 1);
            graph[L] = false;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new boolean[N + 1];

        dfs(1);

        br.close();
    }
}
