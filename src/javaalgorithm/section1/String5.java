package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String5 {

    public static String Solution(String input) {
        char[] charArray = input.toCharArray();
        int lt = 0;
        int rt = charArray.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(charArray);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(Solution(input));
        br.close();
    }
}
