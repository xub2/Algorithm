package javaalgorithm.section2;

import java.util.Scanner;

public class Array7 {

    /*
    1번 문제가 맞는 경우에는 1점으로 계산한다.
    앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다

    또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ...,
    K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            check[i] = sc.nextInt();
        }

        System.out.println(solution(check));

    }

    private static int solution(int[] check) {
        int score = 0;
        int count = 0; // 1을 만나면 cnt증가 -> cnt 값을 score에 누적

        // 정답 : 1 , 오답 : 0
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) {
                count++;
                score += count;
            } else {
                count = 0;
            }
        }

        return score;
    }

}
