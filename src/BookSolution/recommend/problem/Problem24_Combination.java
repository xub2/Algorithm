package BookSolution.recommend.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem24_Combination {

    private static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String x = "ABC";
        combinations(0, x.toCharArray(), "");
        System.out.println(resultList);

    }

    private static void combinations(int idx, char[] order, String result) {
        if (result.length() > 0) { // 문자열의 길이가 0 이상이어야만 추가 -> 아무것도 없으면 추가 X
            resultList.add(result);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}
