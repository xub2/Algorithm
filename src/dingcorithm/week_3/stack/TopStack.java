package dingcorithm.week_3.stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class TopStack {

    /**
     * 5 번째 (높이 = 4) 인 탑이 쏜 신호는 4번째 탑(높이 = 7) 이 받는다.
     * ...
     * 즉 현재 자신의 인덱스 - 1 을 하면서 가장 높은 탑의 높이를 계속 업데이트
     * 정답은 스택 (덱) 으로 저장 이후 추가
     */

    /**
     * 근데 윗 버전처럼 풀면 복잡도가 O(N)^2 이다.
     * 문제 에서 최대 데이터 수가 500,000 개라고 했으니까...
     * 메모리 오버플로우 뜰 듯
     */

    static int[] getReceiverTopOrdersWithStack(int[] heights) {
        int[] answer = new int[heights.length];
        Deque<Integer> heightDeque = new ArrayDeque<>();

        for (int height : heights) {
            heightDeque.push(height);
        }

        while (!heightDeque.isEmpty()) {
            Integer height = heightDeque.pop();
            int currentIndex = heightDeque.size(); // 위에서 pop 했으니 -1 되었을 것

            for (int i = currentIndex - 1; i >= 0; i--) {
                if (height <= heights[i]) { // 신호를 받는 탑이 신호를 받는 조건
                    answer[currentIndex] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputArr = new int[n];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

//        int[] topHeights = {6, 9, 5, 7, 4};

        int[] result = getReceiverTopOrdersWithStack(inputArr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < result.length; i++) {
            if (!(i == result.length - 1)) {
                bw.write(result[i] + " ");
            } else {
                bw.write(result[i]);
            }
        }

        bw.flush();
        bw.close();
    }
}
