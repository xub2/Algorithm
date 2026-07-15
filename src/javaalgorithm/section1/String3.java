package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String3 {

    public static String Solution(String input) {
        String[] split = input.split(" ");
        String answer = split[0];

        for (int i = 1; i < split.length; i++) {
            if (answer.length() < split[i].length()) {
                answer = split[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        br.close();

        System.out.println(Solution(input));

    }
}
