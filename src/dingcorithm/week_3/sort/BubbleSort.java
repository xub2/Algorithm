package dingcorithm.week_3.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] input = {4, 6, 2, 9, 1};

        System.out.println("정렬된 배열 : " + Arrays.toString(bubbleSort(input)));
    }

    private static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                System.out.println(Arrays.toString(array));
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
