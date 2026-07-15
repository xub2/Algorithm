package javaalgorithm.section1;

import java.util.Scanner;

public class String1 {

    public static int Solution(String input, char target) {
        // 둘다 대문자화 해서 비교
        input = input.toUpperCase();
        char c = Character.toUpperCase(target);

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char target = sc.next().charAt(0); // 여기 주의

        System.out.println(Solution(input,target));


    }
}

