package javaalgorithm.section2;

import java.util.Scanner;

public class Array10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 2;
        int[][] arr = new int[n][n];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, arr));

    }

    static int solution(int n, int[][] arr) {
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (
                        (arr[i][j] > arr[i - 1][j]) &&
                        (arr[i][j] > arr[i + 1][j]) &&
                        (arr[i][j] > arr[i][j - 1]) &&
                        (arr[i][j] > arr[i][j + 1])
                ) {
                    count++;
                }
            }
        }

        return count;
    }

}
