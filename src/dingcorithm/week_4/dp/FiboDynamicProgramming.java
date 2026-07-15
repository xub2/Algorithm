// java
package dingcorithm.week_4.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FiboDynamicProgramming {

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(1, 1L);
        memo.put(2, 1L);
    }

    public static void main(String[] args) {
        System.out.println(fiboDynamic(100, memo));
    }

    // 1. 메모에 값이 있으면 반환
    // 2. 없으면 피보나치 공식 적용 및 메모이제이징
    private static Long fiboDynamic(int n, Map<Integer, Long> fiboMemo) {
        if (fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        }

        Long nthFibo = fiboDynamic(n - 1, fiboMemo) + fiboDynamic(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);

        return nthFibo;
    }



}
