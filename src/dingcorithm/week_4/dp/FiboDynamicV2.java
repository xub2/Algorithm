package dingcorithm.week_4.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiboDynamicV2 {

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(1, 1L);
        memo.put(2, 1L);
    }

    private static Long fiboDynamic(int n, Map<Integer, Long> fiboMemo) {
        if (fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        }
        Long nthFibo = fiboDynamic(n - 1, fiboMemo) + fiboDynamic(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);

        return nthFibo;
    }

    public static void main(String[] args) {
        System.out.println(fiboDynamic(100, memo));
    }
}
