package javaalgorithm.section1;

import java.io.*;

public class String4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = Integer.parseInt(br.readLine());

        for (int i = 0; i < time; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            bw.write(sb.reverse().toString());
            bw.newLine();
            bw.flush();

        }
        br.close();
        bw.close();
    }
}
