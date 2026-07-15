package BookSolution.recommend.problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem34 {

    private static ArrayList<Integer>[] adjlist;
    private static boolean[] visited;
    protected static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        adjlist = new ArrayList[n + 1];

        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjlist[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true; // 현재 노드 방문 여부
        answer.add(now); // 이건 결과 출력을 위한 등록

        for (int next : adjlist[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int start = 1;
        int n = 5;

        System.out.println(Arrays.toString(solution(graph, start, n)));
    }
}
