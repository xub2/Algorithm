package dingcorithm.week_1;

public class IsNumberExist {

    static boolean isNumberExist(int num, int[] array) {

        boolean result = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, new int[]{6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, new int[]{6, 9, 2, 7, 1888}));

    }
}
