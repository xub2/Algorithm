package dingcorithm.week_5;

import java.util.Arrays;

public class NewGame {

    public static void main(String[] args) {

        // 말의 개수
        int k = 4;

        // 0 : 흰색
        // 1 : 빨간색
        // 2 : 파란색
        int[][] chessMap = {
                {0, 0, 2, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 2},
                {0, 2, 0, 0},
        };

        // {행 인덱스, 열 인덱스, 이동방향}
        // 이동 방향
        // 0 : -> 동
        // 1 : <- 서
        // 2 : ^ 북
        // 3 : V 남
        int[][] horseLocationAndDirection = {
                {1, 0, 0}, // 1번말 : [1, 0, ->]
                {2, 1, 2}, // 2번말 : [2, 1, ^]
                {1, 1, 0}, // 3반밀 : [1, 1 , ->]
                {3, 0, 1} // 4번말 : [3, 0, <-]
        };

        // 게임이 종료되는 턴의 번호
        // 값이 1000보다 크면 -1 반환


    }

    private static int[] directionRow = {0, 0, -1, 1};
    private static int[] directionColumn = {1, -1, 0, 0};

    private static int getGameOverTurnCount(int k, int[][] chessMap, int[][] horseLocationAndDirection) {
        int turnCount = 0;

        while (turnCount > 1000) {
            for (int i = 0; i < horseLocationAndDirection.length; i++) {
            }
        }

        return 1;
    }


}
