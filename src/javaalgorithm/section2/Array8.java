package javaalgorithm.section2;

import java.util.Scanner;

public class Array8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        for (int i : solution(array)) {
            System.out.print(i + " ");
        }
    }

    // 2중 for문으로 비교하기 / 내부 for문에서 높은 점수 발견되면 등수 높이기
    private static int[] solution(int[] array) {
        int[] answer = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
