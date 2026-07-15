package dingcorithm.week_4.homework;

import java.util.*;

public class NongsimRamenFactory {

    private static int stock = 4;
    private static int[] dates = {4, 10, 15};
    private static int[] supplies = {20, 5, 10};
    private static int k = 30;

    // (현재 재고, 해외 공장 공급 일정[], 해외 공장 일정별 공급 밀가루 수량[], 기존 공장 원복 시점 k)
    private static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastAddedDateIndex = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        while (stock <= k) { // stock 이 k(버텨야하는 날짜) 보다 크면 아무 문제 없이 생존 가능
            // dates 배열의 범위 내부여야 하고 , stock 보다 작거나 같아야한다? 먼소리임
            while (lastAddedDateIndex < dates.length && dates[lastAddedDateIndex] <= stock) { // stock 보다 해당 날짜가 작거나 같아야 해당 날짜까지 도달 가능
                maxHeap.offer(supplies[lastAddedDateIndex]); // 4개의 재고로 4일 납품일까진 버티기 가능 -> 이날 20개 재고 추가 -> 그러나 아직 stock에 반영한건 아님
                lastAddedDateIndex += 1; // 다음 공급 일정 탐색
            }

            answer += 1;
            int heapPop = maxHeap.poll(); // 힙은 항상 최대 값을 뱉어낸다
            stock += heapPop;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(getMinimumCountOfOverseasSupply(stock, dates, supplies, k));
        System.out.println("정답 = 2 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, // 현재 재고는 4개이고
                        new int[]{4, 10, 15},
                        new int[]{20, 5, 10}, // 최소한으로 가져오려면 20 , 10 가져오면 된다
                        30)); // 기존 공장에서 받으려면 30일 필요 -> 즉 최소 26개가 있어야 생존 가능
        System.out.println("정답 = 4 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }
}
