package javaalgorithm.section2;

import java.io.*;

public class Array4 {

    // 피보나치 수열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] result = solution(n);
        // 7이 입력되면 1 1 2 3 5 8 13

        for (int i : result) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    private static int[] solution(int n) {
        int[] result = new int[n];
        result[0] = 1; // 0,1 번 인덱스 초기화
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }

}
