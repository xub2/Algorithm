package javaalgorithm.section7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6 {

    private static int N;
    private static int[] inputArr;
    private static int[] sortedArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        inputArr = new int[N];
        sortedArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            inputArr[i] = number;
            sortedArr[i] = number;
        }

        Arrays.sort(sortedArr);

        for (int i = 0; i < N; i++) {
            if (inputArr[i] != sortedArr[i]) {
                bw.write((i + 1) + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
