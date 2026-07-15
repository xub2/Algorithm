package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem13 {

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {

        int result = 0;

        int[] makeMovesToZeroBaseIndex = Arrays.stream(moves)
                .map(data -> data - 1)
                .toArray();

//        System.out.println(Arrays.toString(makeMovesToZeroBaseIndex));


        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < makeMovesToZeroBaseIndex.length; i++) {
            int targetColumnToGrab = makeMovesToZeroBaseIndex[i];

            for (int j = 0; j < board.length; j++) {
                if (board[j][targetColumnToGrab] != 0) {
                    int doll = board[j][targetColumnToGrab];
                    board[j][targetColumnToGrab] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        result++;
                    } else {
                        stack.push(doll);
                    }

                    break;
                }
            }
        }
        return result * 2;
    }
}
