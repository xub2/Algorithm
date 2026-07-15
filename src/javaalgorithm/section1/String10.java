package javaalgorithm.section1;

import java.util.Scanner;

public class String10 {

    public static int[] Solution(String word, char target) {
        int[] answer = new int[word.length()];
        int p = 1000;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;

        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == target) {
                p = 0; // 이미 0이 들어있을 테니까 그냥 p = 0 만 설정
            } else {
                p++;
                answer[i] = Math.min(answer[i], p); // 기존값과 작은 값으로 비교
            }
        }

        return answer;
    }

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char c = sc.next().charAt(0);

        for (int i : Solution(word, c)) {
            System.out.print(i + " ");

        }
    }
}
