package dingcorithm.week_2.recursive;

public class BosingakCountDown {

    public static void main(String[] args) {
        countDown(60);
//        badCountDown(60);

    }

    public static void countDown(int startNum) {
        if (startNum < 0) { // 재귀함수는 탈출 조건을 반드시 명세
            return;
        }
        System.out.println(startNum);
        countDown(startNum - 1);
    }

    public static void badCountDown(int startNum) {
        System.out.println(startNum);
        badCountDown(startNum - 1);

    }
}
