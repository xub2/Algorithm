package javaalgorithm.section2;

import java.util.Scanner;

public class Array9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] table = new int[n][n];

        // n * n 격자 만들기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(table, n));


    }

    static int solution(int[][] table, int n) {
        /**
         * 1. 가로합 비교
         * 2. 세로합 비교
         * 3. 대각합 비교 -> 두가지 경우의 수
         */

        int max = Integer.MIN_VALUE;

        // 가로합 비교
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < table.length; j++) {
                sum += table[i][j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        // 세로합 비교
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += table[i][j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        // 대각합 비교
        // 1. 좌측 상단에서 우측하단으로 내려가는 대각 arr[i++][j++]
        int crossSumTemp = 0;
        for (int i = 0, j = 0; i < n; i++, j++) {
            crossSumTemp += table[i][j];
        }

        if (crossSumTemp > max) {
            max = crossSumTemp;
        }

        crossSumTemp = 0;

        // 2. 우측 상단에서 좌측 하단으로 내려가는 대각 arr[i++][j--]
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            crossSumTemp += table[i][j];
        }

        if (crossSumTemp > max) {
            max = crossSumTemp;
        }

        return max;
    }
}

//  입력 제대로 됐는지 확인하는 출력 로직
//        for (int[] ints : table) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
