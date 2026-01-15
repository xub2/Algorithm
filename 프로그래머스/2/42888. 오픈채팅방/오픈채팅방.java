import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answerList = new ArrayList<>();
        
        //<id, 이름>
        Map<String, String> hashMap = new HashMap<>();
        for(int i = 0 ; i < record.length; i++){
            String[] splited = record[i].split(" ");
            if(splited[0].equals("Enter")){
                hashMap.put(splited[1], splited[2]);
            } else if(splited[0].equals("Change")){
                hashMap.put(splited[1], splited[2]);
            }
        }
        
        for(int i = 0 ; i < record.length; i++){
            String[] splited = record[i].split(" ");
            String verb = splited[0];
            String id = splited[1];
            
            String currentNickName = hashMap.get(id);
            
            if(verb.equals("Enter")){
                answerList.add(currentNickName + "님이 들어왔습니다.");
            } else if (verb.equals("Leave")){
                answerList.add(currentNickName + "님이 나갔습니다.");
            }
            
        }
        
        String[] answer = new String[answerList.size()];
        
        
        for(int i = 0 ; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
}

// 누가 들어오면 ->"[닉네임]님이 들어왔습니다."
// 누가 나가면 ->"[닉네임]님이 나갔습니다."

// 닉변 방법 : 나갔다가 들어오거나 채팅방에서 변경
// 채팅 방에 들어오고 나가거나 닉변한 기록을 담은 문자열 record
// 최종적으로 보이게 되는 메시지를 문자 배열

// 예시 보면 다음 순번과 같음
// 1. id: uid1234 Muzi 입장
// 2. id: uid4567 Prodo 입장
// 3. id: uid1234 (현재 Muzi) 퇴장
// 4. id: uid1234 (Muzi -> Prodo 닉변) 입장
// 5. id: uid4567 Prodo -> Ryan 닉변


