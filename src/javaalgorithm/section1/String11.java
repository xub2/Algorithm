package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String11 {

    public static String Solution(String str) {
        String answer = "";
        str = str + " ";
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) { // 빈문자열 조심
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                answer += str.charAt(i);
                if (count > 1) {
                    answer += String.valueOf(count);
                    count = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(Solution(str));
    }
}
