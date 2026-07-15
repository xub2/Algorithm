package javaalgorithm.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q8 {

    private static final int MAX = 10000 + 10;

    private static int S, E;
    private static Deque<Integer> queue;
    private static boolean[] visited;
    private static int[] dist;

    private static int[] dir = {1, -1, 5};

    private static int bfs(int idx) {
        queue = new ArrayDeque<>();
        visited = new boolean[MAX];
        dist = new int[MAX];

        int answer = -1;

        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int next = polled + dir[i];

                if (next == E) {
                    return dist[polled] + 1;
                }

                if (next >= 1 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[polled] + 1;
                    queue.offer(next);
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // 현수
        E = Integer.parseInt(st.nextToken()); // 송아지
        // 최단 거리는 5 -> 4(-1) -> 9(+5) -> 14(+5)

        System.out.println(bfs(S));
        br.close();
    }
}
