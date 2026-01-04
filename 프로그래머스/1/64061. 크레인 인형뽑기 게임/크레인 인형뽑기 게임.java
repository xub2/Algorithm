import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
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