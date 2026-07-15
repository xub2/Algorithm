package dfs_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 첫째줄에는 전체 사람수 N
 * 둘째줄에는 촌수 계산 대상 두 번호
 * 셋째줄에는 부모 자식들간의 관계 개수 M
 * 넷째줄부터는 부모 자식 관계를 나타내는 두번호 X,Y
 *
 * 친인척 관계가 없으면 -1 출력
 */

public class Q2644 {

    private static final int MAX = 100 + 10;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static int N, start, end, M;
    private static int answer;

    private static void dfs(int idx, int count) {
        visited[idx] = true;

        if (idx == end) {
            answer = count;
            return;
        }

        for (int i = 0; i < graph[idx].size(); i++) {
            if (!visited[graph[idx].get(i)]) {
                dfs(graph[idx].get(i), count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[MAX];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[MAX];
        answer = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // C1 부터 DFS 시작 -> 언제까지? C2를 만날 때까지만 반복 하면 됨
        dfs(start, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
