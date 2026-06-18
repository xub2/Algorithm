import java.util.ArrayList;

public class Solution {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        int answer = n;
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            // wire[0] - wire[1] 전선을 끊기 위해 wire[1] 노드를 미리 방문 처리
            // → dfs가 wire[0] 쪽에서 wire[1] 노드로 건너가지 못함
            visited[wire[1]] = true;

            // wire[0] 쪽 덩어리의 노드 수를 셈
            int separated = dfs(wire[0]);

            // separated     : wire[0] 쪽 덩어리 크기
            // n - separated : wire[1] 쪽 덩어리 크기
            // 둘의 차이가 가장 작은 경우를 갱신
            answer = Math.min(answer, Math.abs(n - separated * 2));
        }
        return answer;
    }

    private static int dfs(int node) {
        visited[node] = true;
        int size = 1; // 자기 자신 포함

        for (int next : graph[node]) {
            if (visited[next]) {
                continue;
            }
            // 자식 노드의 서브트리 크기를 누적
            size += dfs(next);
        }
        return size;
    }
}