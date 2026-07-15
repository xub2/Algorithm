package BookSolution.recommend.problem;

import java.util.HashSet;
import java.util.Set;

public class Problem18 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }



    private static boolean solution(int[] array, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int currentIndex = i;

            if (set.contains(target - currentIndex)) {
                return true;
            }

            set.add(currentIndex);
        }

        return false;
    }

    /**
     * 그니까 이게
     * 원래 비교하려면 반복문 돌려서 i 와 j 를 비교하는 N^2 연산이 되는데,
     * set(target - 원소) == 해시 셋 안에 있다면 target을 만들 수 있는 두 수가 array에 있다.
     */
}
