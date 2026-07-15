package dingcorithm.week_1;

public class FindCountToTurnNumber {

    public static void main(String[] args) {
        System.out.println(findCountToTurnNumber("011110")); // 예시 출력
    }

    private static int findCountToTurnNumber(String str) {
        int countToZero = 0;
        int countToOne = 0;

        // 첫 번째 문자에 따라 초기값 증가
        if (str.charAt(0) == '0') {
            countToOne++;
        } else {
            countToZero++;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '0') {
                    countToOne++;
                } else {
                    countToZero++;
                }
            }
        }

        return Math.min(countToZero, countToOne);
    }
}
