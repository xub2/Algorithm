package dingcorithm.week_5;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    static String input = "abcabcabcabcdededededede";
    // 2abcabc 2dedede

    public static void main(String[] args) {
        System.out.println(stringCompression(input));

    }

    private static int stringCompression(String s) {
        int answer = s.length(); // 압축이 아예 안 될 경우의 기본값 -> 24

        // 1개 단위부터 s.length()/2 단위까지 시도
        for (int step = 1; step <= s.length() / 2; step++) { // 12 이상 보는건 의미가 없다

            StringBuilder compressed = new StringBuilder();

            String prev = s.substring(0, step); // 첫 번째 조각 // 0 ~ 1 -> ab

            int count = 1;

            // 현재 비교 대상 조각 prev = "ab"

            // step만큼 건너뛰며 다음 조각들과 비교
            // step = 1 / 24 / 1 += 1
            for (int j = step; j < s.length(); j += step) { // 비교를 시작해야하는 위치는 2번 ~ 3번 인덱스
                // 비교할 다음 조각 (마지막 부분 처리 주의)
                String cur;

                if (j + step <= s.length()) {
                    cur = s.substring(j, j + step);
                } else {
                    cur = s.substring(j);
                }

                if (prev.equals(cur)) {
                    count++;
                } else {
                    // 다르다면 압축 문자열 생성
                    if (count >= 2){
                        compressed.append(count);
                    }

                    compressed.append(prev);

                    prev = cur; // 현재 조각을 다음 비교 대상으로 설정
                    count = 1;  // 개수 초기화
                }
            }

            // 반복문이 끝나고 마지막에 남은 조각 처리
            if (count >= 2){
                compressed.append(count);
            }

            compressed.append(prev);

            // 만들어진 압축 문자열 중 가장 짧은 길이 저장
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

}
