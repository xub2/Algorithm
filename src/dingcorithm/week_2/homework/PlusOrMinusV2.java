package dingcorithm.week_2.homework;

import java.util.ArrayList;
import java.util.List;

public class PlusOrMinusV2 {

    static List<Integer> allWays = new ArrayList<>();

    public static void main(String[] args) {
        int targetNumber = 3;
        int[] numbers = {1, 1, 1, 1, 1};

        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus(numbers, targetNumber));
    }

    private static int getCountOfWaysToTargetByDoingPlusOrMinus(int[] array, int target) {
        allWays.clear();
        getAllWaysByDoingPlusOrMinus(array, 0, 0);

        int targetCount = 0;

        for (int way : allWays) {
            if (target == way) {
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
