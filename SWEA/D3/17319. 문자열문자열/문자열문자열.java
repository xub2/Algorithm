import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // 주어진 문자열이 2번 반복되어야 Yes, 아니면 No
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            sc.nextLine();  // 개행 처리
            String input = sc.nextLine();  // 입력 문자열 받기

            // 문자열 길이가 짝수인지 확인
            if (N % 2 != 0) {
                System.out.println("#" + test_case + " No");
                continue;  // 홀수면 바로 다음 테스트 케이스로 넘어감
            }

            char[] inputToString = input.toCharArray();

            // 문자열을 반으로 나누어 두 배열로 생성
            char[] inputToString1 = Arrays.copyOfRange(inputToString, 0, N / 2);
            char[] inputToString2 = Arrays.copyOfRange(inputToString, N / 2 , N);

            // 두 배열을 비교하여 결과 출력
            if (Arrays.equals(inputToString1, inputToString2)) {
                System.out.println("#" + test_case + " Yes");
            } else {
                System.out.println("#" + test_case + " No");
            }
        }
        sc.close();
    }
}
