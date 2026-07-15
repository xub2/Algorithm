package dingcorithm.week_3.sort;

import java.util.Arrays;

public class MergeV2 {

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 5}; // 정렬 되어 있어야 함
        int[] arrayB = {4, 6, 7, 8}; // 정렬 되어 있어야 함

        System.out.println(Arrays.toString(merge(arrayA, arrayB)));

        System.out.println("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11})));
        System.out.println("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, 2, 3, 5, 40}, new int[]{10, 78, 100})));
        System.out.println("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, -1, 0}, new int[]{1, 6, 9, 10})));
    }

    private static int[] merge(int[] arrayA, int[] arrayB) {

        int[] result = new int[arrayA.length + arrayB.length];

        int arrayAPointer = 0;
        int arrayBPointer = 0;
        int resultPointer = 0;

        while (arrayAPointer < arrayA.length && arrayBPointer < arrayB.length) {
            if (arrayA[arrayAPointer] < arrayB[arrayBPointer]) { // a=1 < b=4 -> result는 a부터 추가
                result[resultPointer] = arrayA[arrayAPointer];
                arrayAPointer++;
            } else {
                result[resultPointer] = arrayB[arrayBPointer];
                arrayBPointer++;
            }

            resultPointer++;
        }

        while (arrayAPointer < arrayA.length) {
            result[resultPointer] = arrayA[arrayAPointer];
            arrayAPointer++;
            resultPointer++;
        }

        while (arrayBPointer < arrayB.length) {
            result[resultPointer] = arrayB[arrayBPointer];
            arrayBPointer++;
            resultPointer++;
        }

        return result;

    }

    /**
     * [-1, -1, 0////////////, 1, 6, 9, 10]
     * 0 ~ N/2 = 0 ~ 2 (3 포함 X)
     * N/2 ~ N = 3 ~ 6 (7 포함 X)
     *
     * 주의할 점 : 열린구간은 포함하고, 닫힌 구간은 포함하지 않는다.
     */
}
