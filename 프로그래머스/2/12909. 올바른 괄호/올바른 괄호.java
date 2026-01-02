import java.util.*;

class Solution {
    static boolean solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
        
    }
}