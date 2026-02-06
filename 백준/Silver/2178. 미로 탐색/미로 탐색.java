import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 최소 칸수 -> BFS
public class Main {

    private final static int MAX = 100 + 10;

    private static boolean[][] map;
    private static boolean[][] visited;

    private static int N;
    private static int M;

    private static int answer;

    // 상 하 좌 우
    private static int[] dirY = {-1, 1, 0, 0};
    private static int[] dirX = {0, 0, -1, 1};

    private static void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            // 현재 큐에 들어있는 '같은 거리'의 노드 개수만큼 반복
            int size = queue.size();
            answer++; // 한 단계 이동할 때마다 거리 증가

            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int curY = current[0];
                int curX = current[1];

                // 도착 지점(N, M)에 도달하면 즉시 종료
                if (curY == N && curX == M) {
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int newY = curY + dirY[i]; // curY 기준 이동
                    int newX = curX + dirX[i]; // curX 기준 이동
                    
                    if (map[newY][newX] && !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        queue.offer(new int[]{newY, newX});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (line.charAt(j - 1) == '1') {
                    map[i][j] = true;
                }
            }
        }

        answer = 0;

        bfs(1,1);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
