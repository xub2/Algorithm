import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GraphBfs {

	private static final int MAX = 100 + 10;
	private static int N;

	private static List<Integer>[] adjGraph;
	private static boolean[] visited;
	private static List<Integer> answer;
	private static Deque<Integer> queue;

	private static void bfs(int idx) {
		queue = new ArrayDeque<>();
		visited[idx] = true;
		queue.offer(idx);

		while (!queue.isEmpty()) {
			int polled = queue.poll(); // 1
			answer.add(polled);

			for (int i = 0; i < adjGraph[polled].size(); i++) {
				int next = adjGraph[polled].get(i); // 1번 인덱스 리스트의 i번째 인덱스

				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}

	private static int[] solution(int[][] graph, int start, int n) {
		// N = n
		adjGraph = new ArrayList[MAX];
		visited = new boolean[MAX];
		answer = new ArrayList<>();

		// 그래프 채우기
		for (int i = 0; i < adjGraph.length; i++) {
			adjGraph[i] = new ArrayList<>();
		}

		for(int i = 0; i < graph.length; i++){
			int y = graph[i][0];
			int x = graph[i][1];

			adjGraph[y].add(x);
			adjGraph[x].add(y);
		}

		bfs(start);

		return answer.stream().mapToInt(integer -> integer).toArray();
	}

}
