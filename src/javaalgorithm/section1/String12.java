package javaalgorithm.section1;

import java.util.Scanner;

public class String12 {

    //7바이트씩 끊어야함 -> subString()
    public static String Solution(int n, String input) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = input.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            input = input.substring(7); // 7번째 뒤로부터 쭉 갱신
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();

        System.out.println(Solution(i, input));
    }
}
