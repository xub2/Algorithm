package javaalgorithm.section7;

import java.io.*;
import java.util.StringTokenizer;

// 선택정렬
public class Q1 {

    private static int N;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        //선택 정렬 시작
        int[] sorted = sort(array);

        for (int i : sorted) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {// i = 13 / j = 5
                 index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
}

