class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for(int i = 0 ; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = "김서방은 "+ i + "에 있다";
                break;
            }
        }
        return answer;
    }
}

//문자열 배열 seoul
// Kim의 위치
// 출력 = 김서방은 x에 있다