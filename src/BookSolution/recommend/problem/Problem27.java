package BookSolution.recommend.problem;

import java.util.*;

public class Problem27 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // 1. 자신을 추천한 판매원 정보를 가지고 있으면 쉽다 <자기 자신 : 추천인>
        Map<String, String> enrollAndReferral = new HashMap<>();
        for(int i = 0 ; i < enroll.length; i++){
            enrollAndReferral.put(enroll[i], referral[i]);
        }

        Map<String, Integer> totalProfit = new HashMap<>();

        for(int i = 0 ; i < seller.length; i++){
            String currentSeller = seller[i]; // young 이라 가정
            // 판매자의 판매 금액
            int profit = amount[i] * 100; // young 의 판매 금액은 1200


            /**
             * 예시는 young / 12 = 1200원 이익
             * 이익이 0이면 이익 분배 필요 없음 && 부모 노드가 "-" 면 더이상 상위 부모 없음
             * 인원별 이익금 정리
             * 1. young 에게 발생된 이익금이 1200원이다.
             * 1-1. totalProfit.put(young, totalProfit.getOrDefault(young,0) + (1200 - (1200 * 0.1))) // 기존에 이익금에 현재 이익금 더해주기
             * 2. young의 이익금 10를 줄 부모 찾기
             * 2-1. 탐색 대상 : enrollAndReferral.get(young).equals(edward)
             * 2-2. edward가 갖게될 이익금은 1200 * 0.1 = 120로 profit 업데이트
             *
             * 1. 다시 1번부터 진행
             *  seller == edward, profit == 120
             *  edward의 기존 이익금 + young이 준 이익금 totalProfit.put(edward, totalProfit.getOrDefault(edward,0) + (120 - (120 * 0.1))) -> 에드워드는 88원 이익금 챙김
             *  이후 부모 탐색 -> 탐색 대상 : enrollAndReferral.get(edward).equals(mary)
             *
             *  ...
             *
             * mary는 더이상 부모 노드가 없다 -> 반복문 종료
             */
            while(profit > 0 && !currentSeller.equals("-")){ //
                totalProfit.put(currentSeller, totalProfit.getOrDefault(currentSeller, 0) + profit - (profit / 10));
                currentSeller = enrollAndReferral.get(currentSeller);
                profit = profit / 10;
            }

        }

        // map에 있는 값들 키로 찾아서 옮기기
        for(int i = 0 ; i < enroll.length; i++){
            answer[i] = totalProfit.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
