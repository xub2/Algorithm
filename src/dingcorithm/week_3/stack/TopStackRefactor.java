package dingcorithm.week_3.stack;

import java.io.*;
import java.util.*;

public class TopStackRefactor {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 이건 탑의 개수를 입력받는 변수
        int n = Integer.parseInt(br.readLine());

        // 실제 탑의 높이를 기록하는 변수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] topHeights = new int[n];
        for (int i = 0; i < n; i++) {
            topHeights[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = getReceiverTopOrders(topHeights);

        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] getReceiverTopOrders(int[] topHeights) {
        int[] result = new int[topHeights.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < topHeights.length; i++) {
            int currentHeight = topHeights[i];

            while (!stack.isEmpty() && topHeights[stack.peek()] <= currentHeight) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;
            } else {
                result[i] = 0; // 수신할 탑 없음
            }

            stack.push(i);
        }
        return result;
    }

}
