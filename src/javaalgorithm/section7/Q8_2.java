package javaalgorithm.section7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색으로 풀어보기
public class Q8_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        int lt = 0;
        int rt = N - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == M) {
                answer = mid + 1;
                break;
            }

            if (arr[mid] > M) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
