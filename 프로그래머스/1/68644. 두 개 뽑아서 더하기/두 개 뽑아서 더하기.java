import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < numbers.length; i++){
            for(int j = i + 1 ; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(Integer i : set){
            list.add(i);
        }
        
        int[] array = list.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(array);
        
        return array;
    }
}