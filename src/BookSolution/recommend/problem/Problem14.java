package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem14 {

    public static void main(String[] args) {
        int n = 8; // 행 개수
        int k = 2; // 처음 선택 된 행 번호
        String[] cmd = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd2 = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        // 삭제되지 않은 행은 O / 삭제된 행은 X

        System.out.println(solution(n, k, cmd));
        System.out.println(solution(n, k, cmd2));
    }

    // 배열의 3배럭화
    private static String solution(int n, int k, String[] cmd) {

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++; // 현재 위치는 +1 해야함

        Deque<Integer> deleted = new ArrayDeque<>();

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
            }
        }

        return null;
    }
}

