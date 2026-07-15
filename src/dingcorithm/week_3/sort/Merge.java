package dingcorithm.week_3.sort;

import java.util.Arrays;

public class Merge {

    // 머지의 근간은 result 배열을 새로 만들고, 두 배열에 각각 포인터를 두고 해당 포인터들의 값을 증가시키면서 값 비교
    // 작은수 부터 result에 채우기
    private static int[] merge(int[] arrayA, int[] arrayB) {

        int[] result = new int[arrayA.length + arrayB.length];
        int resultIndex = 0;

        int arrayAIndex = 0;
        int arrayBIndex = 0;

        while (arrayAIndex < arrayA.length && arrayBIndex < arrayB.length) {

            if (arrayA[arrayAIndex] < arrayB[arrayBIndex]) {
                result[resultIndex++] = arrayA[arrayAIndex];
                arrayAIndex++;
            } else {
                result[resultIndex++] = arrayB[arrayBIndex];
                arrayBIndex++;
            }
        }

        // 이 부분까지 하면 두 배열중 하나는 아직 안끝남

        // arrayA가 아직 인덱스가 끝까지 안감 -> 덜끝남
        while (arrayAIndex < arrayA.length) {
            result[resultIndex++] = arrayA[arrayAIndex];
            arrayAIndex++;
        }

        // arrayB가 아직 인덱스가 끝까지 안감 -> 덜끝남
        while (arrayBIndex < arrayB.length) {
            result[resultIndex++] = arrayB[arrayBIndex];
            arrayBIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 5};
        int[] arrayB = {4, 6, 7, 8};

        System.out.println(Arrays.toString(merge(arrayA, arrayB)));

        System.out.println("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11})));
        System.out.println("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, 2, 3, 5, 40}, new int[]{10, 78, 100})));
        System.out.println("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, -1, 0}, new int[]{1, 6, 9, 10})));
    }


}
