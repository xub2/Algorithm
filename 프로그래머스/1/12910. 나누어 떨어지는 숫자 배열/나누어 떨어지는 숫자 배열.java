import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                resultList.add(arr[i]);
            }
        }

        if (resultList.isEmpty()) {
            resultList.add(-1);
        }

        return resultList.stream()
                .mapToInt(integer -> integer.intValue())
                .sorted()
                .toArray();
    }
}