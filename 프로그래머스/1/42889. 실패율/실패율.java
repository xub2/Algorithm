import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) { // N : 5 / stages = [2,1,2,6,2,4,3,3]
        
        int players = stages.length;
        Map<Integer,Integer> stageCount = new HashMap<>();

        for(int stage : stages){
            if (!stageCount.containsKey(stage)) {
                stageCount.put(stage, 1);
            } else {
                stageCount.put(stage, stageCount.get(stage) + 1);
            }
        }

        Map<Integer, Double> failurePercentMap = new HashMap<>();
        // 1 base index
        for(int i = 1 ; i <= N ; i++){
            int currentStageFailurePlayers = stageCount.getOrDefault(i, 0);

            if (players == 0) {
                failurePercentMap.put(i, 0.0);
            } else {
                double failurePercent = (double)currentStageFailurePlayers / players;
                failurePercentMap.put(i, failurePercent);
            }
            players -= currentStageFailurePlayers;
        }

        return failurePercentMap.keySet().stream()
                .sorted((o1, o2) -> {
                    double f1 = failurePercentMap.get(o1);
                    double f2 = failurePercentMap.get(o2);
                    if (f1 == f2) return Integer.compare(o1, o2); // 실패율 같으면 작은 번호 먼저
                    return Double.compare(f2, f1); // 실패율 내림차순
                })
                .mapToInt(Integer::intValue)
                .toArray();

    
    }
}