package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class String6 {

    public static String Solution(String string) {
        Set<Character> set = new LinkedHashSet<>();
        char[] charArray = string.toCharArray();
        StringBuilder answer = new StringBuilder();

        for (char c : charArray) {
            set.add(c);
        }

        for (Character c : set) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(Solution(str));

    }
}
