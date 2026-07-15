package javaalgorithm.section6;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q3 {

    static int N, M;
    static int[][] board;
    static int[] moves;

    static Deque<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        M = Integer.parseInt(br.readLine());
        moves = new int[M];

        stack = new ArrayDeque<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int col = moves[i] - 1; // moves는 1 base index -> 0 base index로 바꾸자

            for (int j = 0; j < N; j++) {
                if (board[j][col] != 0) {

                    if (!stack.isEmpty() && stack.peek() == board[j][col]) {
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(board[j][col]);
                    }

                    board[j][col] = 0;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer * 2));
        bw.flush();
        bw.close();
        br.close();
    }
}
