package dingcorithm.week_2.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeV2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(isPalindromeRecursive(input));

    }

    private static boolean isPalindromeRecursive(String input) {

        // 먼저 문자열 길이 구하기
        int n = input.length();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) != input.charAt(n - 1 - i)) {
                return false; // 맨 앞과 맨 뒤 글자가 다르면 바로 탈출
            }
        }

        return true;
    }
}



