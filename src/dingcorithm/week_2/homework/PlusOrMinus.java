package dingcorithm.week_2.homework;

import java.util.ArrayList;
import java.util.List;

public class PlusOrMinus {

    static List<Integer> allWays = new ArrayList<>();

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int targetNumber = 3;

        System.out.println(getCountOfWaysToMakeTargetNumber(numbers, targetNumber));
    }

    /**
     * N 길이의 배열에서 더하거나 뺀 모든 경우의 수는
     * N - 1 길이의 배열에서 마지막 원소를 더하거나 뺀 경우의 수를 추가하면 된다
     */
    public static int getCountOfWaysToMakeTargetNumber(int[] numbers, int targetNumber) {

        allWays.clear();
        getAllWaysByDoingPlusOrMinus(numbers, 0, 0);


        int targetCount = 0;
        for (int way : allWays) {
            if (targetNumber == way) {
                targetCount += 1;
            }
        }

        return targetCount;
    }

    private static void getAllWaysByDoingPlusOrMinus(int[] array, int currentIndex, int currentSum) {
        if (currentIndex == array.length) {
            allWays.add(currentSum);
            return;
        }
        getAllWaysByDoingPlusOrMinus(array, currentIndex + 1, currentSum + array[currentIndex]);
        getAllWaysByDoingPlusOrMinus(array, currentIndex + 1, currentSum - array[currentIndex]);
    }


}
