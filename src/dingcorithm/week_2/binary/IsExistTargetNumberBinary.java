package dingcorithm.week_2.binary;

import java.util.Arrays;

public class IsExistTargetNumberBinary {

    public static void main(String[] args) {

        int target = 2;
        // 이진 탐색은 반드시 정렬이 되어있어야 한다 !!!!!!
        int[] numbers = {0, 3, 5, 6, 1, 2, 4};
        Arrays.sort(numbers);

        System.out.println("==순차 탐색==");
        sequentialMethod(numbers, target);
        System.out.println("==이진 탐색==");
        binarySearch(numbers, target);
    }

    private static void sequentialMethod(int[] numbers, int target) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            count++;

            if (numbers[i] == target) {
                System.out.println("숫자 " + target + "을 " + i + "번째 인덱스에서 찾았습니다.");
                System.out.println("연산 횟수 : " + count);
            }
        }
    }

    private static void binarySearch(int[] numbers, int target) {
        int currentMin = 0;
        int currentMax = numbers.length - 1;
        int currentGuess = (currentMin + currentMax) / 2;
        int count = 0;

        while (currentMin <= currentMax) {
            count++;
            if (numbers[currentGuess] == target) {
                System.out.println("숫자 " + target + "을 " + currentGuess + "번째 인덱스에서 찾았습니다.");
                System.out.println("연산 횟수 : " + count);
                break;
            } else if (numbers[currentGuess] < target) {
                currentMin = currentGuess + 1;
            } else {
                currentMax = currentGuess - 1;
            }

            currentGuess = (currentMin + currentMax) / 2;
        }
    }
}
