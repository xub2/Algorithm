package dingcorithm.week_3.queue;

import java.util.*;

public class StockWithQueue {

    static List<Integer> solution(int[] prices) {

        /**
         * i가 j 보다 크면 주가가 내려간 것
         * i가 j보다 작으면 주가가 올라간 것
         * 즉, 끝까지 탐색 하되, prices[i] == prices[j] 를 만족하는 순간까지 count 후 result 등록
         */

        List<Integer> result = new ArrayList<>();
        Deque<Integer> priceDeque = new ArrayDeque<>();

        for (int i : prices) {
            priceDeque.offer(i);
        }

        while (!priceDeque.isEmpty()) {
            int priceNotFallSecond = 0;
            int currentPrice = priceDeque.poll(); // currentPrice = 1 || priceDeque = 2 <- 3 <- 2 <- 3

            Deque<Integer> tempDeque = new ArrayDeque<>(priceDeque);

            for (Integer nextPrice : tempDeque) {
                if (currentPrice <= nextPrice) { // 주가 상승 || 동결
                    priceNotFallSecond++;
                } else {
                    priceNotFallSecond++;
                    break;
                }
            }

            result.add(priceNotFallSecond);
        }

        return result;
    }

    static void printList(List<Integer> solution) {
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i));

            if (i < solution.size() - 1) {
                System.out.print(", ");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        printList(solution(new int[]{1, 2, 3, 2, 3}));
    }
}
