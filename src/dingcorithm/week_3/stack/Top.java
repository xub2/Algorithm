package dingcorithm.week_3.stack;

import java.util.*;

public class Top {

    /**
     * 5 번째 (높이 = 4) 인 탑이 쏜 신호는 4번째 탑(높이 = 7) 이 받는다.
     * ...
     * 즉 현재 자신의 인덱스 - 1 을 하면서 가장 높은 탑의 높이를 계속 업데이트
     * 정답은 스택 (덱) 으로 저장 이후 추가
     */

    static int[] getReceiverTopOrders(int[] heights) {
        int[] answer = new int[heights.length];

        // i 번째 인덱스가 레이저를 쏘는 탑
        for (int i = heights.length - 1; i > 0; i--) {

            // j 번쨰 인덱스 탑이 받아 줄 수 있는지를 검사하면 된다.
            // 즉, 현재 쏘고 있는 i의 높이가 레이저를 받아주는 j의 높이보다 작거나 같으면 j가 레이저를 받아줄 수 있음
            for (int j = i - 1; j >= 0; j--) {
//                System.out.println(heights[i] + ", " +heights[j]);
                if (heights[i] <= heights[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
//            System.out.println("--------");
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inputArr = new int[n];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = sc.nextInt();
        }

//        int[] topHeights = {6, 9, 5, 7, 4};

        int[] result = getReceiverTopOrders(inputArr);

        for (int i = 0; i < result.length; i++) {
            if (!(i == result.length - 1)) {
                System.out.print(result[i] + " ");
            } else {
                System.out.print(result[i]);
            }

        }
    }
}
