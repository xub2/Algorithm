package BookSolution.recommend.problem;

import java.util.*;

public class Problem42 {

    private static final int MAX = 100 + 10;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static int N, answer;

    private static int dfs(int idx) {
        visited[idx] = true;
        int size = 1;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (!visited[next]) {
                int childSize = dfs(next); // 자식 서브트리 크기
                size = size + childSize;  // 자식 크기를 현재 size에 누적
            }
        }

        return size;
    }

    public static int solution(int n, int[][] wires) {
        graph = new ArrayList[MAX];
        N = n;
        answer = n;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            // 1. 전선 끊기 -> wire[1] 번째 노드를 방문 처리 하면 끊는 것 처럼 표현 가능
            visited = new boolean[MAX];
            visited[wire[1]] = true;

            // 2. dfs(1) 결과를 int 로 받아서 (전체 노드 수 N - dfs(1)) 하면 무조건 다음처럼 나옴
            // dfs(1) -> 집합 1
            // N - dfs(1) -> 집합 2
            int set1 = dfs(wire[0]);
            int set2 = N - set1;

            // 지금 그러면 집합 1과 집합 2가 나옴
            int dif = Math.abs(set1 - set2); // 차이를 절대값으로 계산
            answer = Math.min(answer, dif); // 최초에 answer은 9였다 -> 1회 dfs 때 dif = |1 - 8| == 7 -> 차이가 더 적은 7로 교체

        }

        return answer;
    }

    public static void main(String[] args) {
        Problem42 problem42 = new Problem42();

        System.out.println(problem42.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
