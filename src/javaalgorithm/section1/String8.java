package javaalgorithm.section1;

import java.io.*;

public class String8 {

    public static String Solution(String str) {
        String answer = "YES";
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : charArray) {
            if (Character.isAlphabetic(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }

        if (!sb.toString().equals(sb.reverse().toString())) {
            return "NO";
        }

        return answer;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        bw.write(Solution(str));
        bw.flush();
        br.close();
        bw.close();
    }
}
