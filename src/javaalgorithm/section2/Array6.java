package javaalgorithm.section2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Array6 {
    // 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, arr);

       // --------------------- 숫자 뒤집기 완료 ----------------

        // 소수 판별 로직 작성
    }

    private static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
        }

        return answer;
    }

    public boolean isPrime(int num) {

        return true;
    }

}
