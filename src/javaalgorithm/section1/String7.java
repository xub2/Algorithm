package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String7 {

    public static String Solution(String str) {
        String answer = "YES";

        String upperCase = str.toUpperCase();
        StringBuilder sb = new StringBuilder(upperCase).reverse();

        if (!upperCase.equals(sb.toString())) {
            answer = "NO";
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        System.out.println(Solution(str));
    }
}
