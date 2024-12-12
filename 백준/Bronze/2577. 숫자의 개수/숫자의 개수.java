import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 곱셈 결과 계산
        int result = a * b * c;

        // 결과를 문자열로 변환
        String resultToString = Integer.toString(result);

        // 각 숫자의 등장 횟수를 저장할 배열 (0~9)
        int[] count = new int[10];

        // 각 숫자를 순회하며 등장 횟수 카운트
        for (char ch : resultToString.toCharArray()) {
            int digit = ch - '0'; // 문자 '0'을 빼서 정수로 변환
            count[digit]++;
        }

        // 결과 출력
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
