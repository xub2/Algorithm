package dingcorithm.week_4.homework;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {
    private static int stock = 4;
    private static int[] dates = {4, 10, 15};
    private static int[] supplies = {20, 5, 10};
    private static int k = 30;

    public static void main(String[] args) {
        System.out.println(getMinimumCountOfOverseasSupply(stock, dates, supplies, k));
        System.out.println("정답 = 2 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, // 남은 밀가루
                        new int[]{4, 10, 15}, // 밀가루가 들어오는 날짜
                        new int[]{20, 5, 10},  // 밀가루 들어오는 수량
                        30)); // 원래 공장에서 받을 수 있는 시점
        System.out.println("정답 = 4 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }

    private static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastAddedDateIndex = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        while (stock <= k) {
//            while (dates[lastAddedDateIndex])
        }

        return 0;
    }
}
