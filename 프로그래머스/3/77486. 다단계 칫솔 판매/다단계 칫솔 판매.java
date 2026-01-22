import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 1. 자신을 추천한 판매원 정보를 가지고 있으면 쉽다 <자기 자신 : 추천인>
        Map<String, String> enrollAndReferral = new HashMap<>();
        for(int i = 0 ; i < enroll.length; i++){
            enrollAndReferral.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> totalProfit = new HashMap<>();
        
        for(int i = 0 ; i < seller.length; i++){
            String currentSeller = seller[i];
            // 판매자의 판매 금액
            int profit = amount[i] * 100;
            
            while(profit > 0 && !currentSeller.equals("-")){
                totalProfit.put(currentSeller, totalProfit.getOrDefault(currentSeller, 0) + profit - (profit / 10));
                currentSeller = enrollAndReferral.get(currentSeller);
                profit = profit / 10;
            }
            
        }

        for(int i = 0 ; i < enroll.length; i++){
            answer[i] = totalProfit.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
}

// 예를 들어 예시에서 sam이 5개 팔았다 -> 이익금 500원
// 그러면 500 * 0.1 한 만큼 edward에게 분배
// 그리고 (500 * 0.1) * 0.1 만큼 mary 에게 분배