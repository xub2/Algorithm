import java.util.*;
public class Tangerine {

    public int solution(int k, int[] tangerineSizeArray) {
        int answer = 0;

        Map<Integer, Integer> tangerineSizeMap = new HashMap<>();
        for (int size : tangerineSizeArray) {
            if (!tangerineSizeMap.containsKey(size)) {
                tangerineSizeMap.put(size, 1);
            } else {
                tangerineSizeMap.put(size, tangerineSizeMap.get(size) + 1);
            }
        }

        List<Integer> sizeCounts = new ArrayList<>(tangerineSizeMap.values());
        sizeCounts.sort(Comparator.reverseOrder()); // 컬렉션을 정렬 / 역정렬하는 법 기억해 놓자

        for (Integer sizeCount : sizeCounts) {
            k = k - sizeCount;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Tangerine tangerine = new Tangerine();
        System.out.println(tangerine.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(tangerine.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(tangerine.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));

    }
}
