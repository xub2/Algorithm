package programmers;

public class ConvertWord {

    int answer = 0;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        // target이 words 배열에 아예 없으면 변환 불가
        boolean hasTarget = false;

        for (String w : words) {
            if (w.equals(target)){
                hasTarget = true;
            }
        }

        if (!hasTarget) {
            return 0;
        }

        dfs(begin, target, words, 0);

        return answer;
    }

    public void dfs(String current, String target, String[] words, int count) {
        // 1. 종료 조건: target에 도달했을 때
        if (current.equals(target)) {
            // DFS는 여러 경로를 찾으므로, 그 중 가장 작은(최단) 값을 저장
            if (answer == 0 || count < answer) {
                answer = count;
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canConvert(current, words[i])) {
                visited[i] = true; // hot에 대해 방문 처리
                dfs(words[i], target, words, count + 1);
                visited[i] = false; // ★ 중요: 백트래킹 (다른 경로도 탐색하기 위해 방문 해제)
            }
        }
    }

    // 한 글자만 다른지 확인하는 함수
    private boolean canConvert(String s1, String s2) {
        int diffCount = 0;

        /**
         * 0 번째 인덱스 기준
         * 현재 hit이란 단어가 hot과 한 글자만 다른지
         * h != h == false
         * o != i == true -> diffCount++
         * t != t == false
         * => (diffCount == 1) == true
         */
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}
