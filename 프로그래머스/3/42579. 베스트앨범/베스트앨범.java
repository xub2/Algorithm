import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 데이터 수집: 장르별 [고유번호, 재생횟수] 리스트와 장르별 총 재생 횟수 합산
        Map<String, List<int[]>> genreWithSongListMap = new HashMap<>();
        Map<String, Integer> genreAndPlayTimeMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 노래 목록 추가 (new ArrayList로 가변 리스트 생성)
            genreWithSongListMap.putIfAbsent(genres[i], new ArrayList<>());
            genreWithSongListMap.get(genres[i]).add(new int[]{i, plays[i]});
            
            // 장르별 총 재생 횟수 누적
            genreAndPlayTimeMap.put(genres[i], genreAndPlayTimeMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 장르 정렬: 총 재생 횟수가 많은 순서대로 장르 이름 리스트 생성
        List<String> sortedGenres = genreAndPlayTimeMap.keySet().stream()
                .sorted((o1, o2) -> genreAndPlayTimeMap.get(o2).compareTo(genreAndPlayTimeMap.get(o1)))
                .collect(Collectors.toList());

        // 3. 정답 추출을 위한 리스트
        List<Integer> resultList = new ArrayList<>();

        // 4. 각 장르를 순회하며 조건에 맞게 노래 추출
        for (String genre : sortedGenres) {
            List<int[]> songs = genreWithSongListMap.get(genre);

            // 장르 내 노래 정렬
            // 조건 1: 재생 횟수(int[1]) 내림차순
            // 조건 2: 재생 횟수가 같으면 고유 번호(int[0]) 오름차순
            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            // 최대 2곡까지 결과 리스트에 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                resultList.add(songs.get(i)[0]);
            }
        }

        // List<Integer>를 int[] 배열로 변환하여 반환
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}



// 하려는 짓 : 장르별 가장 많이 재생된 노래를 두개씩 모아 앨범 출시
// 노래 수록 기준 :
// 1. 속한 노래가 많이 재생된 장르 먼저 수록 -> 장르부터 실어라
// 2. 그 다음에 해당 장르 내에서 많이 재생된 노래를 수록 -> 여기서 노래 수록
// 3. 장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래 먼저 수록 -> DESC

// 장르로 먼저 정렬
// 장르는 반드시 다 들어감
// 다만 해당 장르 노래 는 두곡
// 즉 장르의 개수가 N이면 답은 N * 2이겠지?

// Task
// 1. 장르와 재생횟수 인덱스로 <음반 id, 재생횟수> 저장 -> 장르를 키로 없으면 키 추가 / 있으면 
// 1-1. 장르별 재생횟수 총합 통계구하기

// 2. 재생횟수 총합 통계 기준 장르별 내림차순 정렬 -> 많은 장르부터 정렬되겠지?

// 3. 해당 장르를 키값으로 맵 탐색 -> 내림차순 정렬 되어 있는 것에서 상위 두개 뽑아오기 -> 이거 아닌 듯

// 4. 결과에 추가