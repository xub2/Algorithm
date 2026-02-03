import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N; // 사람
    private static int A, B; // A와 B 간의 촌수 계산
    private static int M; // 관계 개수
    private static int answer;

    private static void dfs(int idx, int count) {
        visited[idx] = true;

        if (idx == B) {
            answer = count;
            return;
        }

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i); // 실제 연결된 노드 번호를 가져옴

            if (visited[next] == false) {
                dfs(next, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        answer = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 7 -> 2depth (1번 기준)
        B = Integer.parseInt(st.nextToken()); // 3 -> 1depth (1번 기준)

        M = Integer.parseInt(br.readLine());

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(A, 0);

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
