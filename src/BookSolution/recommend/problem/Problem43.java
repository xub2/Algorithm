package BookSolution.recommend.problem;

import java.util.ArrayList;
import java.util.List;

// 1부터 N까지 숫자중 합이 10이 되는 조합 -> 백트래킹

/**
 * 정수 N을 입력 받아 1부터 N까지 숫자중에 합이 10이 되는 조합을 리스트로 반환하라
 */
public class Problem43 {

    private static class Solution{

        private static List<List<Integer>> result;
        private static int N;

        private static void backTrack(int sum, ArrayList<Integer> selectedNums, int start) {

            if (sum == 10) {
                result.add(selectedNums);
                return;
            }

            // 10이 되기 전까지만 가본다.
            // 1일 때 가정
            for (int i = start; i <= N; i++) { // i = 1

                if (sum + i <= 10) {
                    ArrayList<Integer> list = new ArrayList<>(selectedNums); // 새 리스트 생성
                    list.add(i);
                    backTrack(sum + i, list, i + 1);
                }
            }
        }

        public List<List<Integer>> solution(int n) {
            result = new ArrayList<>();
            N = n;

            backTrack(0, new ArrayList<>(), 1);
            return result;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
