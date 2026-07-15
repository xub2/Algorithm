package dingcorithm.week_3.queue;

import java.io.*;
import java.util.*;

public class Stock {

    static int[] solution(int[] prices) {

        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {

            int priceNotFallSecond = 0;

            for (int j = i + 1; j < prices.length ; j++) {
                /**
                 * i가 j 보다 크면 주가가 내려간 것
                 * i가 j보다 작으면 주가가 올라간 것
                 * 즉, 끝까지 탐색 하되, prices[i] == prices[j] 를 만족하는 순간까지 count 후 result 등록
                 */

                if (prices[i] <= prices[j]) { // j가 크거나 같으면 떨어지지 않았음
                    priceNotFallSecond++;
                } else {
                    priceNotFallSecond++; // 곧장 떨어져도 1초가 유지되어야 한다
                    break;
                }
            }

            result[i] = priceNotFallSecond;

        }

        return result;
    }


    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));

    }
}
