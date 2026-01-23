import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> typeCountMap = new HashMap<>();
        for(int n : nums){
            if(!typeCountMap.containsKey(n)){
                typeCountMap.put(n, 1);
            } else {
                typeCountMap.put(n, typeCountMap.get(n) + 1);
            }
        }
        
        int keepablePokemon = nums.length/2;
        
        if(typeCountMap.size() >= keepablePokemon){
            return keepablePokemon;
        } else {
            return typeCountMap.size();
        }
        
    }
}

// 가질 수 있는 포켓몬 수는 nums.length / 2
// nums의 원소를 키 값으로 Map에 저장 <Integer, Integer>

// 만약 키 개수가 가질 수 있는 포켓몬 수 보다 많다 (map.size > pokemon)
// 

// 만약 키 개수와 가질 수 있는 포켓몬 수가 같다

// 만약 키 개수가 가질 수 있는 포켓몬 수 보다 적다