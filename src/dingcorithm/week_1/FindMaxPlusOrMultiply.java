package dingcorithm.week_1;

public class FindMaxPlusOrMultiply {

    public static void main(String[] args) {
        System.out.println("정답 = 728 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{0, 3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 8820 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{3, 2, 1, 5, 9, 7, 4}));
        System.out.println("정답 = 270 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{1, 1, 1, 3, 3, 2, 5}));
    }

    /**
     * 대개 곱하는게 더하는 것 보다 크게 나온다. 하지만 다음과 같은 상황은 제외한다
     * 1. 곱하는 수 중 0이 있다면
     * 2. 곱하는 수 중 1이 있다면
     * 3. 곱하는 수가 음수라면 ? -> 요건 나중에 추가
     */
    static int findMaxPlusOrMultiply(int[] array) {
        int result = array[0];

        // 0이나 1이면 더하기가 유리하다
        for (int i = 1; i < array.length; i++) {
            if (result <= 1 || array[i] <= 1) {
                result += array[i];
            } else {
                result *= array[i];
            }
        }

        return result;
    }
}
