package javaalgorithm.section7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3 {

	private static int N;
	private static int[] array;

	private static void insertSort(int[] array) {
		for (int i = 1; i < N; i++) {
			int target = array[i];
			int j;

			for (j = i - 1; j >= 0; j--) { // j는 i 기준 배열의 0번 인덱스까지 뒤로 감소
				if (array[j] > target) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}

			array[j + 1] = target;
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

		insertSort(array);

		for (int i : array) {
			bw.write(i + " ");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
