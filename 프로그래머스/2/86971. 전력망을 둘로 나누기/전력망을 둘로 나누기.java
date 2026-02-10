import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {

    private static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래ㅔ프 채우기
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int nodeA = wires[i][0];
            int nodeB = wires[i][1];

            int groupSize = getCount(nodeA, nodeB, n);

            int diff = Math.abs(groupSize - (n - groupSize));

            if (diff < answer) {
                answer = diff;
            }
        }

        return answer;
    }

    private int getCount(int start, int ignore, int n) {
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int next : graph[curr]) {
                if (next == ignore) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count;
    }

}