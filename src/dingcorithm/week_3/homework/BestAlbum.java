package dingcorithm.week_3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록
 */
public class BestAlbum {
    public static void main(String[] args) {
        System.out.print("정답 = [4, 1, 3, 0] / 현재 풀이 값 = ");
        System.out.println(getMelonBestAlbum(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}));

        System.out.print("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = ");
        System.out.println(getMelonBestAlbum(
                new String[]{"hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"},
                new int[]{2000, 500, 600, 150, 800, 2500, 2000}));
    }

    static List<Integer> getMelonBestAlbum(String[] genreArray, int[] playArray) {

        Map<String, Integer> genrePlayMap = new HashMap<>();

        for (int i = 0; i < genreArray.length; i++) {
            if (genrePlayMap.containsKey(genreArray[i])) {

                genrePlayMap.put(genreArray[i], Integer.valueOf(genrePlayMap.get(genreArray[i])));
            }

            genrePlayMap.put(genreArray[i], playArray[i]);
        }

        System.out.println("genrePlayMap = " + genrePlayMap);

        return List.of();
    }
}
