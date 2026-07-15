package dingcorithm.week_3.homework;

import java.util.Arrays;
import java.util.Collections;

public class MaxDiscount {

    public static void main(String[] args) {

        System.out.println("정답 = 926000 / 현재 풀이 값 = " +
                getMaxDiscountedPrice(new int[]{30000, 2000, 1500000}, new int[]{20, 40}));

        System.out.println("정답 = 485000 / 현재 풀이 값 = " +
                getMaxDiscountedPrice(new int[]{50000, 1500000}, new int[]{10, 70, 30, 20}));

        System.out.println("정답 = 1550000 / 현재 풀이 값 = " +
                getMaxDiscountedPrice(new int[]{50000, 1500000}, new int[]{}));

        System.out.println("정답 = 1458000 / 현재 풀이 값 = " +
                getMaxDiscountedPrice(new int[]{20000, 100000, 1500000}, new int[]{10, 10, 10}));

    }

    static int getMaxDiscountedPrice(int[] prices, int[] coupons) {

        Integer[] pricesBoxed = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] couponsBoxed = Arrays.stream(coupons).boxed().toArray(Integer[]::new);

        Arrays.sort(pricesBoxed, Collections.reverseOrder());
        Arrays.sort(couponsBoxed, Collections.reverseOrder());

        int priceIndex = 0;
        int couponIndex = 0;
        int maxDiscountedPrice = 0;

        while (priceIndex < pricesBoxed.length && couponIndex < couponsBoxed.length) { // 현재 가격과 쿠폰이 모두 배열 내의 원소일떄
            int discountedPrice = pricesBoxed[priceIndex] * (100 - couponsBoxed[couponIndex]) / 100;
            maxDiscountedPrice += discountedPrice;
            priceIndex++;
            couponIndex++;
        }

        while (priceIndex < pricesBoxed.length) { // 즉, 현재 price_index 가 prices 길이 범위 내라면,
            maxDiscountedPrice += pricesBoxed[priceIndex];
            priceIndex++;
        }

        return maxDiscountedPrice;
    }
}

