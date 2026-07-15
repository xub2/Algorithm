package javaalgorithm.section7;

import java.io.*;
import java.util.StringTokenizer;

public class Q5 {

    private static int N;
    private static int[] stuNum;

    private static boolean isDuplicated(int number) {
        for (int i = 0; i < stuNum.length; i++) {
            if (stuNum[i] == number) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stuNum = new int[N];

        String answer = "U";

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isDuplicated(number)) {
                answer = "D";
                break;
            } else {
                stuNum[i] = number;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
