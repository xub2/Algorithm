package dingcorithm.week_2.binary;

public class IsExistingTargetNumberBinary {

    public static void main(String[] args) {
        int target = 14;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println("==순차 탐색==");
        findTargetWithSequential(numbers, target);
        System.out.println("==이진 탐색==");
        findTargetWithBinary(numbers, target);
    }

    private static void findTargetWithSequential(int[] numbers, int target) {
        int findCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            findCount++;
            if (numbers[i] == target) {
                System.out.println("숫자 " + target + "을 " + i + "번째 인덱스에서 찾았습니다.");
                System.out.println("검색 횟수 : " + findCount);
                break;
            }
        }
    }

    private static void findTargetWithBinary(int[] numbers, int target) {
        // 인덱스를 잘 가지고 놀아야 한다
        // 가운데인 8을 시도
        // 최대 값, 최소 값, 탐색하는 값이 모두 변수로 필요하다.
        int current_min = 0;
        int current_max = numbers.length - 1;
        int current_guess = (current_min + current_max) / 2;
        int findCount = 0;

        // 최대 값이 최소 값과 동일해질 때까지 탐색해야함 -> 예를 들어 찾고자 하는 값이 가장 뒤에 있으면 최소 값 == 최대 값 까지 옮겨야 함
        while (current_min <= current_max) {
            findCount++;

            if (numbers[current_guess] == target) {
                System.out.println("숫자 " + target + "을 "+ current_guess + "번째 인덱스에서 찾았습니다.");
                System.out.println("검색 횟수 : " + findCount);
                break;
            } else if (numbers[current_guess] < target) { // 최소 값이 탐색 했던 숫자보다 +1 만큼 앞으로 가야함
                current_min = current_guess + 1;
            } else { // numbers[current_guess] > target -> 반대로 최대 값을 탐색 숫자 기준 -1 해줘야 한다
                current_max = current_guess - 1;
            }

            current_guess = (current_min + current_max) / 2;
        }
    }
}
