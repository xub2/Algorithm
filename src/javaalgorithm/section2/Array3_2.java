package javaalgorithm.section2;

import java.io.*;
import java.util.StringTokenizer;

public class Array3_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arrA = new int[n];
        int[] arrB = new int[n];

        String inputA = br.readLine();
        StringTokenizer stA = new StringTokenizer(inputA, " ");

        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = Integer.parseInt(stA.nextToken());
        }

        String inputB = br.readLine();
        StringTokenizer stB = new StringTokenizer(inputB, " ");

        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = Integer.parseInt(stB.nextToken());
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가위 : 1 , 바위 : 2 , 보 : 3
        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) {
                bw.write("D");
            } else if (arrA[i] == 1 && arrB[i] == 3) {
                bw.write("A");
            } else if (arrA[i] == 2 && arrB[i] == 1) {
                bw.write("A");
            } else if (arrA[i] == 3 && arrB[i] == 2) {
                bw.write("A");
            } else {
                bw.write("B");
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

