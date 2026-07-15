package javaalgorithm.section8;

public class Q9 {

    private static final int MAX = 5 + 10;

    private static boolean[][] graph;
    private static boolean[] visited;

    private static void dfs(int index, int count) {
        visited[index] = true;
        boolean isLeaf = true;

        for (int i = 1; i < graph[index].length; i++) {
            if (!visited[i] && graph[index][i]) {
                isLeaf = false;
                dfs(i, count + 1);
            }
        }

        if (isLeaf) {

        }
    }

    private static int bfs() {
        visited = new boolean[MAX];

        //todo
        return 0;
    }

    public static void main(String[] args) {

        graph = new boolean[MAX][MAX];

        graph[1][2] = true;
        graph[1][3] = true;
        graph[2][1] = true;
        graph[2][4] = true;
        graph[2][5] = true;
        graph[3][1] = true;
        graph[4][2] = true;
        graph[5][2] = true;

        visited = new boolean[MAX];
        dfs(1, 0);

        System.out.println(bfs());



    }
}
