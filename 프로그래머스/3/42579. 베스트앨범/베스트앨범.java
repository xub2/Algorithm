import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreCountMap = new HashMap<>();
        Map<String, List<Integer>> genreIndexArrayMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (!genreCountMap.containsKey(genres[i])) {
                genreCountMap.put(genres[i], plays[i]);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                genreIndexArrayMap.put(genres[i], list);
            } else {
                genreCountMap.put(genres[i], genreCountMap.get(genres[i]) + plays[i]);
                genreIndexArrayMap.get(genres[i]).add(i);
            }
        }

        // 장르 내 곡 재생횟수 내림차순, 재생횟수 같으면 고유번호 오름차순
        for (List<Integer> indexList : genreIndexArrayMap.values()) {
            indexList.sort((a, b) -> {
                if (plays[b] != plays[a]) {
                    return plays[b] - plays[a];
                }
                return a - b;
            });
        }

        // 장르 총 재생횟수 내림차순 정렬
        List<String> keyList = new ArrayList<>(genreCountMap.keySet());
        keyList.sort((a, b) -> genreCountMap.get(b) - genreCountMap.get(a));

        // 장르 순서대로 최대 2곡씩 수록
        List<Integer> result = new ArrayList<>();
        for (String genre : keyList) {
            List<Integer> indexList = genreIndexArrayMap.get(genre);
            for (int i = 0; i < Math.min(2, indexList.size()); i++) {
                result.add(indexList.get(i));
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}