import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        // 1. 입력 MAP 완성
        Map<String, Integer> wantMap = new HashMap<>();
        
        for(int i = 0 ; i < want.length; i++){
            if(!wantMap.containsKey(want[i])){
                wantMap.put(want[i], number[i]);
            } else {
                wantMap.put(want[i], wantMap.get(want[i]) + number[i]);
            }
        }
        
        //13
        // 2. i일부터 ++ 해가면서 map 만들기
        for(int i = 0 ; i < discount.length - 9; i++){
            Map<String, Integer> compareMap = new HashMap<>();
            
            for(int j = i; j < i + 10; j++){
                if(!compareMap.containsKey(discount[j])){
                    compareMap.put(discount[j], 1);
                } else {
                    compareMap.put(discount[j], compareMap.get(discount[j]) + 1);
                }
            }
            
            if(wantMap.equals(compareMap)){
                answer++;
            }
        }
        
        return answer;
        
    }
}