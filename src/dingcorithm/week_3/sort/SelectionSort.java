package dingcorithm.week_3.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] input = {4, 6, 2, 9, 1};

        System.out.println("정렬된 배열 : " + Arrays.toString(selectionSort(input)));
    }

    private static int[] selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = 0; j < n - i; j++) {
                if (array[i + j] < array[minIndex]) {
                    minIndex = i + j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}
