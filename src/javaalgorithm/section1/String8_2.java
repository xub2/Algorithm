package javaalgorithm.section1;

import java.io.*;

/**
 * replaceAll() + 정규표현식
 */

public class String8_2 {

    public static String Solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // 알바펫이 아닌것(^) 은 삭제("")

        String sb = new StringBuilder(str).reverse().toString();
        if (str.equals(sb)) {
            answer = "YES";
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
