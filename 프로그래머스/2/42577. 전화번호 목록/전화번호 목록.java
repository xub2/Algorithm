/**
100만 이하 -> O(N) 이하
**/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    
        Set<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for (String phone : phone_book){
            for(int i = 1; i < phone.length(); i++){
                if(set.contains(phone.substring(0,i))) return false;
            }
        }
        
        return true;
    }
}