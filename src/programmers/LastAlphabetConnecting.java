package programmers;

import java.util.*;

public class LastAlphabetConnecting {

    static int[] solution(int n, String[] words) {

        // 중복 단어 체크를 위한 Set
        Set<String> wordSet = new HashSet<>();

        // 첫 번째 단어는 검사할 필요가 없으므로 미리 추가
        if (words.length > 0) {
            wordSet.add(words[0]);
        }

        // 두 번째 단어(인덱스 1)부터 검사 시작
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String previousWord = words[i - 1];

            // 1. 끝말잇기 규칙 검사
            char lastChar = previousWord.charAt(previousWord.length() - 1);
            char firstChar = currentWord.charAt(0);

            // 2. 중복 단어 검사
            boolean isDuplicate = wordSet.contains(currentWord);

            // 규칙 위반 (끝말잇기 실패) 또는 중복 단어인 경우
            if (lastChar != firstChar || isDuplicate) {
                // 탈락자 발생!
                int personNumber = (i % n) + 1; // 탈락한 사람
                int turnNumber = (i / n) + 1;   // 탈락한 사람의 차례

                return new int[]{personNumber, turnNumber};
            }

            // 통과한 경우, 현재 단어를 Set에 추가
            wordSet.add(currentWord);
        }

        // 루프가 끝날 때까지 아무도 탈락하지 않음
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        int n = 3;

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(solution(n, words)));
    }

}
