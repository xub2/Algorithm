import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution  {

    private static ArrayList<int[]>[] graph;
    private static int[] record;

    private static void bfs(int currentLocation, int currentTime) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{currentLocation, currentTime});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int location = polled[0];
            int time = polled[1];

            // 1번부터 5번 마을까지
            // 1번에 연결 되어 있는 노드들이 갈 수 있는만큼만 가면 된다
            // 1번에 연결되어 있는 애들로 못가는 노드 어차피 못감
            for (int i = 0; i < graph[location].size(); i++) {
                int[] temp = graph[location].get(i);
                int nextLocation = temp[0];
                int weight = temp[1];

                // 현재 위치부터 다음 위치까지 걸리는 시간 (가중치)
                int nextTime = time + weight;

                // 만약 연결된 위치까지 걸리는 시간이 현재 기록되어 있는 시간보다 작다면
                if (nextTime < record[nextLocation]) {
                    // 적은 값을 갱신
                    record[nextLocation] = nextTime;
                    queue.offer(new int[]{nextLocation, nextTime});
                }
            }
        }
    }

    public int solution(int N, int[][] road, int K) {

        // 리스트부터 채웁시다
        graph = new ArrayList[N + 1];
        record = new int[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            record[i] = Integer.MAX_VALUE;
        }

        int n = road.length;
        int m = road[0].length;

        for (int i = 0; i < road.length; i++) {
            int[] temp = road[i];

            int start = temp[0];
            int end = temp[1];
            int weight = temp[2];

            graph[start].add(new int[]{end, weight});
            graph[end].add(new int[]{start, weight});
        }

        record[1] = 0;
        bfs(1, 0);

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (record[i] <= K) {
                count++;
            }
        }

        return count;
    }
}
