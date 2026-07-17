import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] numToStr = new String[numbers.length];
        for(int i = 0 ; i < numToStr.length; i++){
            numToStr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numToStr, new CustomComparator());
        
        if (numToStr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < numToStr.length; i++){
            sb.append(numToStr[i]);
        }
        
        return sb.toString();
    }
    
     private static class CustomComparator implements Comparator<String>{
        @Override
        public int compare(String left, String right) {
            return (right + left).compareTo(left + right);
        }
    }
}