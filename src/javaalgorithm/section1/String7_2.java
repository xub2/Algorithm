package javaalgorithm.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Builder 패턴으로 풀어도 되지만 입력 글자를 2로 나눈 몫만큼만 반복문을 수행하는 방식을 택해도 된다 -> for(i < length / 2)
 * 위 는 짝수 기준이지만, 홀수 스트링도 어차피 가운데 글자가 반환점이 되기떄문에 똑같이 풀어주면 된다
 */

public class String7_2 {

    public static String Solution(String str) {
        str = str.toUpperCase();
        String answer = "YES";
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) { // 인덱스 비교 공식 주의
                return "NO";
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        System.out.println(Solution(str));
    }
}
