import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> dictionary = new HashSet<>();
        dictionary.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String prevWord = words[i - 1];
            String currWord = words[i];
            
            if(prevWord.charAt(prevWord.length() - 1) != currWord.charAt(0) ||
              dictionary.contains(currWord)){
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            dictionary.add(currWord);
        }

        return new int[] {0,0};
        
    }
}

// 나머지 연산을 쓸 때가 온건가?