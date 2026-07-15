import java.util.ArrayList;
import java.util.List;

public class GraphDfs {

	private static final int MAX = 100 + 10;

	private static boolean[][] adjGraph;
	private static boolean[] visited;

	private static List<Integer> answer;

	private static void dfs(int idx) {
		visited[idx] = true;
		answer.add(idx);

		for (int i = 0; i < MAX; i++) {
			if (adjGraph[idx][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static int[] solution(int[][] graph, int start) {
		adjGraph = new boolean[MAX][MAX];
		visited = new boolean[MAX];

		answer = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			adjGraph[graph[i][0]][graph[i][1]] = true;
			adjGraph[graph[i][1]][graph[i][0]] = true;
		}

		dfs(start);

		return answer.stream()
			.mapToInt(integer -> integer)
			.toArray();
	}

}
