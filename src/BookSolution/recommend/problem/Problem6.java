package BookSolution.recommend.problem;

import java.util.HashMap;

public class Problem6 {

    public int[] solution(int N, int[] stages) {
        // ❶ 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];

        for (int stage : stages) { // O(M)
            challenger[stage] += 1;
        }

        // ❷ 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // ❸ 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) { // O(N)
            if (challenger[i] == 0) { // ❹ 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.0); // O(1)
            } else {
                fails.put(i, challenger[i] / total); // ❺ 실패율 구함
                total -= challenger[i]; // ❻ 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        // ❼ 실패율이 높은 스테이지부터 내림차순으로 정렬 (정렬시 O(N + log(N))
        return fails.
                entrySet() // Entry(키, 값) 으로 된 Set으로 변환
                .stream() // 스트림 시작
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())) // Set에서 Entry 2개씩 가져와서 비교 (값을 비교)
                .mapToInt(entry -> entry.getKey())
                .toArray();
    }
}
