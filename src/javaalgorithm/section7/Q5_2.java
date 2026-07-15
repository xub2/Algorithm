package javaalgorithm.section7;

import java.io.*;
import java.util.*;

public class Q5_2 {

    private static int N;
    private static Set<Integer> stuNum;

    private static boolean isDuplicated(int number) {
        if (stuNum.contains(number)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stuNum = new HashSet<>();

        String answer = "U";

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isDuplicated(number)) {
                answer = "D";
                break;
            } else {
                stuNum.add(number);
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
