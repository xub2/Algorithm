package dingcorithm.week_3.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxDiscountV2 {

    public static void main(String[] args) {

        // 최대 할인? -> 가장 높은 가격에 가장 높은 쿠폰 적용하면 됨
        int[] price = {30000, 2000, 1500000};
        int[] discountPercent = {20, 40};

        System.out.println(getMaxDiscountedPrice(price, discountPercent));
    }

    private static int getMaxDiscountedPrice(int[] priceArray, int[] discountPercentArray) {
        // 둘다 내림차순 정렬
        Integer[] priceArrayDesc = sortArrayDesc(priceArray);
        Integer[] discountPercentDesc = sortArrayDesc(discountPercentArray);

        int totalPrice = 0;
        int index = 0;

        // 반복문 범위는 쿠폰 기준으로 잡고, 이후 남은 값들 flush
        while (index < priceArrayDesc.length && index < discountPercentDesc.length) {
            int originalPrice = priceArrayDesc[index];
            int discount = discountPercentDesc[index];

            totalPrice += originalPrice - (int) (originalPrice * discount * 0.01);
            index++;
        }

        // 남은 값들 차례대로 더하기
        while (index < priceArrayDesc.length) {
            totalPrice += priceArrayDesc[index];
            index++;
        }

        return totalPrice;
    }

    private static Integer[] sortArrayDesc(int[] array) {
        Integer[] arrayDesc = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayDesc[i] = array[i];
        }

        Arrays.sort(arrayDesc, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arrayDesc));

        return arrayDesc;
    }
}
