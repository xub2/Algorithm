package javaalgorithm.section2;

import java.util.*;


public class Array11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        System.out.println(solution(arr, n));


    }

    static int solution(int[][] arr, int n) {

        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } else {
                    for (int k = 0; k < 5; k++) {
                        if (arr[i][k] == arr[j][k]) {
                            count++;
                            break;
                        }
                    }
                }
            }

            if (count > max) {
                max = count;
                answer = i + 1;
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
