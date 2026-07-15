package dingcorithm.week_3.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class TopStackV2 {

    public static void main(String[] args) {

        int[] topHeights = {6, 9, 5, 7, 4};

        System.out.println(Arrays.toString(getReceiverTopOrders(topHeights)));
    }

    /**
     * 4
     * 7
     * 5
     * 9
     * 6
     */

    /**
     * 위처럼 넣었을 때 뺀 숫자 기준으로 pop 해가면서 자기보다 크면 바로 그 숫자가 신호를 수신하는 탑
     */

    private static int[] getReceiverTopOrders(int[] topHeights) {
        int[] result = new int[topHeights.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int topHeight : topHeights) {
            deque.push(topHeight);
        }

        while (!deque.isEmpty()) {
            int height = deque.pop(); //높이 : 4 인덱스 : 4
            int currentIndex = deque.size(); // pop 했으니까 사이즈는 4맞음

            // 4 .. 3.. 2.. 1.. 0
            // 본인은 볼 필요 없으니 3부터 비교
            for (int i = currentIndex - 1; i >= 0; i--) {
                if (height <= topHeights[i]) { // 만약 현재 신호를 쏘는 탑 높이보다 해당 인덱스에 있는 탑의 높이가 높다면
                    // 해당 인덱스의 탑이 신호 수신
                    result[currentIndex] = i + 1; // 그러나 우리는 0 base 인덱스가 아닌 1 base 인덱스 이므로 +1 해줘야 함
                    break;
                }
            }
        }

        return result;
    }

}
