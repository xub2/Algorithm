package dingcorithm.week_1;

public class FindMaxNum {

    static int findMaxNumV1(int[] array) {
        int result = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > result) {
                result = array[i];
            }
        }

        return result;
    }

    static int findMaxNumV2(int[] array) {
        int result = array[0];

        for (int i = 0; i < array.length; i++) {
            boolean isMaxNum = true;

            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    isMaxNum = false;
                    break;
                }
            }

            if (isMaxNum) {
                result = array[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("====findMaxNumV1====");
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNumV1(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNumV1(new int[]{6,6,6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNumV1(new int[]{6, 9, 2, 7, 1888}));

        System.out.println("====findMaxNumV2====");
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNumV2(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNumV2(new int[]{6,6,6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNumV2(new int[]{6, 9, 2, 7, 1888}));

    }
}
