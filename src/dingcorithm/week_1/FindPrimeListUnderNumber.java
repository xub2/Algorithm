package dingcorithm.week_1;

import java.util.ArrayList;

public class FindPrimeListUnderNumber {

    public static void main(String[] args) {
        System.out.println(findPrimeListUnderNumber(20));
    }

    // 소수는 1과 자기 자신을 약수로 갖는다 -> 1은 소수가 아님 -> 하지만 2는 소수
    private static ArrayList<Integer> findPrimeListUnderNumber(int number) {
        ArrayList<Integer> primeNumberList = new ArrayList<>();

        for (int i = 2; i < number + 1; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeNumberList.add(i);
            }

        }

        return primeNumberList;
    }


}
