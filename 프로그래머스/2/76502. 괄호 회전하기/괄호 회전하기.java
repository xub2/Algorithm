import java.util.*;

class Solution {
    public int solution(String s) {
        
        int result = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            
            String rotated = s.substring(i) + s.substring(0,i);
            
            if(isVaild(rotated)){
                result++;
            }
        }
        return result;
    }
    
    private static boolean isVaild(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                
                char peek = stack.peek();
                
                if((c == ']' && peek == '[')
                  || (c == '}' && peek == '{')
                  || (c == ')' && peek == '('))
                {
                    stack.pop();
                } else {
                    // 짝이 안맞는 경우도 false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}