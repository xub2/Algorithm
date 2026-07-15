package javaalgorithm.section2;

import java.util.*;

public class Array2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] studentHeight = new int[n];

        for(int i = 0 ; i < studentHeight.length; i++){
            studentHeight[i] = sc.nextInt();
        }

        System.out.println(solution(studentHeight));
    }

    private static int solution(int[] input) {
        int count = 1; // 맨 앞은 보이니까
        int tallest = input[0];

        // 2 중포문 사용시 시간 초과
        for (int i = 1; i < input.length; i++) {
            if (input[i] > tallest) {
                count++;
                tallest = input[i];
            }
        }

        return count;
    }
}
