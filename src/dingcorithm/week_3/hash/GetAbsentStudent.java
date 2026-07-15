package dingcorithm.week_3.hash;

import java.util.HashMap;
import java.util.Map;

public class GetAbsentStudent {

    public static void main(String[] args) {
        String[] all_students = {"나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"};
        String[] present_students = {"정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"};

        System.out.println(getAbsentStudent(all_students, present_students));

        System.out.println("정답 = 예지 / 현재 풀이 값 = " +
                getAbsentStudent(new String[]{"류진","예지","채령","리아","유나"},
                        new String[]{"리아","류진","채령","유나"}));

        System.out.println("정답 = RM / 현재 풀이 값 = " +
                getAbsentStudent(new String[]{"정국","진","뷔","슈가","지민","RM"},
                        new String[]{"뷔","정국","지민","진","슈가"}));
    }

    private static String getAbsentStudent(String[] allStudents, String[] presentStudents) {

        Map<String, Boolean> students = new HashMap<>();

        // 먼저 맵에 다 채움
        for (String student : allStudents) {
            students.put(student, true);
        }

        // 그 다음에 현재원들을 키 값으로 지움
        for (String presentStudent : presentStudents) {
            students.remove(presentStudent);
        }

        // 남은 키값으로 students 조회하며 해당 키를 반환
        for (String key : students.keySet()) {
            return key;
        }

        return null;
    }

}
