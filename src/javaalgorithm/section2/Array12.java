package javaalgorithm.section2;

import java.util.Scanner;


public class Array12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(arr, n, m));


    }

    // 복집도(O(n)^2 * M * N) -> M,N은 범위가 지정되어 있으므로 약 O(n)^2
    static int solution(int[][] arr, int n, int m) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;

                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) {
                            pi = l;
                        }
                        if (arr[k][l] == j) {
                            pj = l;
                        }
                    }

                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }


}

//for (int[] ints : arr) {
//        for (int i : ints) {
//        System.out.print(i + " ");
//            }
//                    System.out.println();
//        }
