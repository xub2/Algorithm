package javaalgorithm.section1;

import java.io.*;

public class String9 {

    public static int Solution(String str) {
        StringBuilder answer = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (Character.isDigit(c)) {
                answer.append(c);
            }
        }

        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(String.valueOf(Solution(str)));
        bw.flush();
        br.close();
        bw.close();
    }
}
