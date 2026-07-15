package dingcorithm.week_4.dp;

public class FiboRecursion {

    // 피보나치 수열의 20번째 수 구하기 - 재귀 함수
    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(100));

    }
}
