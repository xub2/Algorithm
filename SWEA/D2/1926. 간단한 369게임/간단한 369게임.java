import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 사용자 입력 받기
        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);  // 숫자를 문자열로 변환
            int count = 0;  // '3', '6', '9' 등장 횟수 세기 위한 변수
            
            // '3', '6', '9'가 문자열에 있는지 확인
            for (int j = 0; j < num.length(); j++) {
                char c = num.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    count++;  // 등장 횟수를 증가시킴
                }
            }
            
            // 등장한 '3', '6', '9'의 개수에 따라 출력
            if (count > 0) {
                for (int k = 0; k < count; k++) {
                    System.out.print("-");
                }
            } else {
                System.out.print(i);  // '3', '6', '9'가 없으면 숫자 출력
            }
            
            System.out.print(" ");  // 각 출력 사이에 공백 추가
        }
        
        sc.close();
    }
}
