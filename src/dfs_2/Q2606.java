package dfs_2;

import java.io.*;
import java.util.StringTokenizer;

public class Q2606 {

    private static boolean[][] graph;
    private static boolean[] visited;
    private static int N, M;
    private static int answer;

    private static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i < graph[idx].length; i++) {

            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 컴터 수
        M = Integer.parseInt(br.readLine());// 입력 받을 횟수

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        // 숙주 노드는 빼야하기 때문
        bw.write(String.valueOf(answer - 1));
        bw.flush();

        br.close();
        bw.close();
    }


}
