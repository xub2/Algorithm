package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Q1012 {

    private static boolean[][] map;
    private static boolean[][] visited;
    private static int T;
    private static int N; // 세로 길이
    private static int M; // 가로 길이
    private static int K;

    private final static int MAX = 50 + 10;

    // 상 하 좌 우
    private static int[] dirY = {-1, 1, 0, 0};
    private static int[] dirX = {0 ,0, -1, 1};

    private static void dfs(int y, int x) {
        // 1. DFS는 반드시 해당 구역을 방문했다느 증거를 남겨야 한다
        visited[y][x] = true;

        // 해당 좌표 구역부터 상하좌우를 보고 방문하지 않은 구역이면 하나씩 방문 시작(재귀)
        // 상하좌우 4번 확인
        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            // 상 하 좌 우 배추가 있고 방문하지 않았다면 재귀 호출
            if (map[newY][newX] && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()); // 가로 / 호수
                int y = Integer.parseInt(st.nextToken()); // 세로 / 층

                map[y + 1][x + 1] = true;
            }

            int answer = 0;

            // 배추의 위치를 기준으로 DFS 실행해야 한다.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // 해당 좌표에 배추가 심어져 있고, 방문하지 않은 좌표라면 해당 좌표를 기준으로 DFS 실행
                    if (map[i][j] == true && visited[i][j] == false) {
                        answer++; // 지렁이 한마리 투하
                        dfs(i,j); // i,j 를 기준으로 지렁이의 방어구역 팀섹 시작
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();

            T--;
        }

        br.close();
        bw.close();
    }

}
