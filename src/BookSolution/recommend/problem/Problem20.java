package BookSolution.recommend.problem;

import java.util.*;

public class Problem20 {

    private static int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // n 일차 회원가입시 할인 받아 살 수 있는 품목과 개수
        // 14 - 9 = 5 -> 4번 인덱스까지만 봐도 된다.
        // 그래야 그 인덱스 날 기준 10일까지 비교 가능
        for (int i = 0; i < discount.length - 9; i++) { // 특정일 기준 10일이 왜 -9 인가 -> i번째 날부터 10일간의 데이터를 봐야한다
            Map<String, Integer> discount10d = new HashMap<>();

            // i 인덱스부터 i + 10 번째 인덱스의 원소가 모두 같아야 함
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}
