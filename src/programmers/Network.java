package programmers;

public class Network {

    static final int MAX = 200 + 10;

    static boolean[][] graph;
    static boolean[] visited;

    static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].length; i++) {
            if (graph[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        graph = new boolean[MAX][MAX];
        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1) {
                    graph[i][j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Network network = new Network();
        System.out.println(network.solution(n, computers));
    }
}
