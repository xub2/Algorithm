package dingcorithm.week_3.sort;

import java.util.Arrays;

public class BubbleSortV2 {

    public static void main(String[] args) {
        int[] arrayForBubbleSort = {4, 6, 2, 9, 1};

        System.out.println(Arrays.toString(bubbleSort(arrayForBubbleSort)));
    }

    private static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+ 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

}
