package javaalgorithm.section8;

import java.io.*;

public class Q4 {

    private static int[] fibo;

    private static int fibo(int n) {

        if (fibo[n] > 0) { // 메모이제이션 : 값이 있다
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = fibo(n - 2) + fibo(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];

        fibo(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }

    }
}
