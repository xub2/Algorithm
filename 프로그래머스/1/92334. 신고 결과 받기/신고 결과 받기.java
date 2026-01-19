import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { 
        
        int[] finalResult = new int[id_list.length];
        
        // 인원 만큼 정답 map 만들기
        Map<String, Set<String>> resultMap = new LinkedHashMap<>();
        for(String s: id_list){
            resultMap.put(s, new LinkedHashSet<String>());
        }
        // 채우기 OK
        
        // 유저별 신고당한 횟수 0 으로 초기화
        Map<String, Integer> reportCountMap = new LinkedHashMap<>();
        for(String s : id_list){
            reportCountMap.put(s, 0);
        }
        
        // 중복 신고 거르기
        Set<String> verifyDuplicatedReport = new LinkedHashSet<>();
        
        for(String s: report){
            verifyDuplicatedReport.add(s);
        }
        
        
        for(String log : verifyDuplicatedReport){
            //"muzi frodo" -> muzi가 frodo 신고
            String[] splitReportLog = log.split(" ");
            String reporter = splitReportLog[0]; // 신고자
            String reported = splitReportLog[1]; // 신고 당한 인원
            
            // 유저가 누구 신고 했는지 기록
            // muzi : [frodo]
            resultMap.get(reporter).add(reported);
            
            // 신고당한 횟수 업데이트
            // frodo : 1
            // 중복 신고 로직 어케 처리함?
            reportCountMap.put(reported, reportCountMap.get(reported) + 1);
            
        }
        
        // 이 시점에 신고당한 횟수 정리 끝
        
        // 정지 대상 인원 이름 리스트
        Set<String> banTargetUser = new LinkedHashSet<>();
        // k 번 이상 신고 당했으면 정지 대상 인원 리스트에 추가
        for(String key : reportCountMap.keySet()){
            if(reportCountMap.get(key) >= k){
                banTargetUser.add(key);
            }
        }
        
        
        if(banTargetUser.isEmpty()){
            return new int[id_list.length];
        }
        
        
        for (int i = 0; i < id_list.length; i++) {
    String reporter = id_list[i];
    Set<String> myReportList = resultMap.get(reporter);
    
    int mailCount = 0;
    for (String reportedUser : myReportList) {
        if (banTargetUser.contains(reportedUser)) {
            mailCount++;
        }
    }
    finalResult[i] = mailCount;
}
        
        return finalResult;
    }
}

// 필요 Map
// <유저 id : 신고 당해 정지 당했다고 받은 정지 인원 이름 메일>
// <유저 id : 신고당한 횟수>

// 이용자 아이디 (id_list)
// 각 이용자가 신고한 이용자의 ID정보 (report)
// 정지 기준 k
// 유저별로 받은 처리 결과 메일 횟수 배열 출력

// 각 유저는 한번에 한명의 유저 신고 가능 (1트 1신고)
// 신고 횟수는 제한 없음. 하지만 동일한 유저에 대한 신고 횟수는 1회로 처리

// k 번 이상 신고 된 유저는 정지
// 해당 유저를 신고한 모든 유저에게 정시 사실 메일 발송
// 유저가 신고한 모든 내용 취합 + 마지막에 한꺼번에 게시판 이용 정지 -> 정지 메일 발송

// 그니까 정지된 인원 수 만큼 메일 발송