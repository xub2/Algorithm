import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> resultSet = new HashSet<>();
        
        for(int i = 0 ; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                resultSet.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(Integer i : resultSet) {
            resultList.add(i);
        }
        
        int[] result = resultList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(result);
        
        return result;
    }
}