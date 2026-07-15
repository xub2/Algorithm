package dingcorithm.week_3.sort;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort {

    public static void main(String[] args) {

        int[] input = {4, 6, 2, 9, 1};
        Integer[] newInput = {4, 6, 2, 9, 1};

        System.out.println("정렬된 배열 : " + Arrays.toString(insertionSort(input)));
        Arrays.sort(newInput, Comparator.reverseOrder());
        System.out.println(Arrays.toString(newInput));
    }

    private static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i - j] < array[i - j - 1]) {
                    int temp = array[i - j];
                    array[i - j] = array[i - j - 1];
                    array[i - j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

}
