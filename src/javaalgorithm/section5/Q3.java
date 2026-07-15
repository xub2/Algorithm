package javaalgorithm.section5;

import java.util.*;
import java.io.*;

public class Q3 {

    static int N;
    static int K; // 연속 된 날

    static int[] sales;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sales = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < sales.length; i++){
            sales[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - K + 1; i++) {
            Set<Integer> salesSet = new HashSet<>();

            for (int j = i; j < i + K ; j++) {
                salesSet.add(sales[j]);
            }

            bw.write(String.valueOf(salesSet.size()) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
