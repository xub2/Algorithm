package dingcorithm.week_4.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class GetAllWaysOfTheaterSeat {

//    private static int seatCount = 9;
//    private static int[] vipSeatArray = {4, 7};

    private static Map<Integer, Integer> memo = new HashMap<>();
    static{
        memo.put(0, 1);
        memo.put(1, 1);
        memo.put(2, 2);
    }

    // 1. 메모에 이미 해당 값이 있으면 반환한다.
    // 2. 만약 없다면, 그 값을 피보나치를 통해 구하고 메모에 저장한다.
    public static int fiboDynamicProgramming(int n, Map<Integer, Integer> fiboMemo) {
        if (fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        }

        int nthFibo = fiboDynamicProgramming(n - 1, fiboMemo) + fiboDynamicProgramming(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);

        return nthFibo;
    }

    public static int getAllWaysOfTheaterSeat(int totalCount, int[] fixedSeatArray) {
        int allWays = 1;
        int currentIndex = 0;

        for (int fixedSeat : fixedSeatArray) {
            int fixedSeatIndex = fixedSeat - 1;
            int countOfWays = fiboDynamicProgramming(fixedSeatIndex - currentIndex, memo);
            allWays *= countOfWays;
            currentIndex = fixedSeatIndex + 1;
        }

        int countOfWays = fiboDynamicProgramming(totalCount - currentIndex, memo);
        allWays *= countOfWays;

        return allWays;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] vipSeatArray = new int[m];
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(br.readLine());
            vipSeatArray[i] = input;
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(getAllWaysOfTheaterSeat(n, vipSeatArray)));

        bw.flush();
        bw.close();
    }
}
