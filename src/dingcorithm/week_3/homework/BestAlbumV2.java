package dingcorithm.week_3.homework;

import java.util.*;

public class BestAlbumV2 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(getMelonBestAlbum(genres, plays));
    }

    public static List<Integer> getMelonBestAlbum(String[] genreArray, int[] playArray) {
        int n = genreArray.length;
        Map<String, Integer> genreTotalPlayDict = new HashMap<>();
        Map<String, List<int[]>> genreIndexPlayArrayDict = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String genre = genreArray[i]; // classic
            int play = playArray[i]; // 500

            if (genreTotalPlayDict.containsKey(genre)) { //classic 이라는 키값이 있었으면
                genreTotalPlayDict.put(genre, genreTotalPlayDict.get(genre) + play); //재생횟수를 더해줘야 할테니까요
                genreIndexPlayArrayDict.get(genre).add(new int[]{i, play});
            } else { //키 값이 없는 상황이라면
                genreTotalPlayDict.put(genre, play); // 500
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, play});
                genreIndexPlayArrayDict.put(genre, list);
            }
        }

        // 장르별로 가장 재생횟수가 많은 장르들 중, 곡수가 많은 순서대로 2개씩 출력하기.
        List<Map.Entry<String, Integer>> sortedGenrePlayList = new ArrayList<>(genreTotalPlayDict.entrySet());
        sortedGenrePlayList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedGenrePlayList) {
            String genre = entry.getKey();
            List<int[]> genreIndexPlayList = genreIndexPlayArrayDict.get(genre);

            // Sort by play count (descending), then by index (ascending) if play counts are equal
            genreIndexPlayList.sort((a, b) -> {
                if (b[1] != a[1]) {
                    return b[1] - a[1]; // Sort by play count descending
                } else {
                    return a[0] - b[0]; // Sort by index ascending
                }
            });

            int genreSongCount = 0;
            for (int[] indexPlay : genreIndexPlayList) {
                if (genreSongCount >= 2) {
                    break;
                }

                result.add(indexPlay[0]);
                genreSongCount++;
            }
        }

        return result;
    }


}
