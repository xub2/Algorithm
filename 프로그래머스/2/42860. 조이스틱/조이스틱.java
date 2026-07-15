class Solution {
    
    private static final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
     
    public int solution(String name) {
        int count = 0;
        String[] nameArr = name.split("");
        int length = nameArr.length;
        
        int minMove = length - 1;
        
        for(int i = 0 ; i < length; i++) {
            String target = nameArr[i];
            
            int nextAlphabet = findNextAlphabet(target);
            int reverseAlphabet = findReverseAlphabet(target);
            
            count += Math.min(nextAlphabet, reverseAlphabet);
            
            int next = i + 1;
            
            while(next < length && nameArr[next].equals("A")){
                next++;
            }
            
            int viaLeftFirst = 2 * i + (length - next);
            int viaRightFirst = i + 2 * (length - next);
            
            minMove = Math.min(minMove, Math.min(viaLeftFirst,viaRightFirst));
        }
        
        count += minMove;
        return count;
    }
    
    private static int findNextAlphabet(String target){
        int count = 0;
        
        for(int i = 0 ; i < alphabet.length; i++){
            if(alphabet[i].equals(target)){
                return count;
            } 
            
            count++;
        }
        
        return count;
    }
    
    private static int findReverseAlphabet(String target){
        if(target.equals("A")){
                return 0;
            }
        
        int count = 1;
        
        for(int i = alphabet.length -1 ; i > 0 ; i--) {
            if(alphabet[i].equals(target)){
                return count;
            } 
            
            count++;
        }
        
        return count;
    }
}
    
    

  // ^ : A -> B -> C
        // V : A -> Z -> Y
        // < : 커서 왼쪽 이동 (단 첫번재 위치에서 쓰면 제일 마지막으로 커서 감)
        // > : 커서 오른족 이동 (단 마지막 위치에서 쓰면 제일 처음으로 커서 감))
    

/*
최소 이동이면 양쪽으로 확인 해야 하나 ?
두가지 방식으로 탐색 후 비교 -> 적은 값을 정답에 누적
*/