package javaalgorithm.section7;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q8 {

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
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < N; i++) {
            if(arr[i] == M){
                bw.write(String.valueOf(i + 1));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
