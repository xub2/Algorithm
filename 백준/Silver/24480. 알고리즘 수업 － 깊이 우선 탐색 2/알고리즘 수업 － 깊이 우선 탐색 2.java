import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private final static int MAX = 1000000 + 10;
    private static ArrayList<Integer>[] graph; // Integer을 담을 리스트를 담을 배열
    private static boolean[] visited;
    private static int N;
    private static int M;
    private static int R;
    private static int[] answer;
    private static int order; // 몇번째로 방문헀는지 카운트할 변수

    private static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = order;
        order++;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if (visited[next] == false) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 1. 그래프 연결정보 채우기
        graph = new ArrayList[MAX];
        for (int i = 1; i <= N; i++) { // 1 ~ 5까지
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Comparator.reverseOrder());
        }

        // 3. dfs 호출
        dfs(R);

        // 4. 출력
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.close();
        br.close();

    }
}
