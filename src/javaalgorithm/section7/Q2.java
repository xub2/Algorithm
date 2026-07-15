package javaalgorithm.section7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 버블 정렬
public class Q2 {

	private static int N;
	private static int[] array;

	private static void bubbleSort(int[] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		array = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		bubbleSort(array);

		for (int i : array) {
			bw.write(i + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
