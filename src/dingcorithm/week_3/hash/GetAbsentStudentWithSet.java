package dingcorithm.week_3.hash;

import java.util.HashSet;
import java.util.Set;

public class GetAbsentStudentWithSet {

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
        Set<String> presentSet = new HashSet<>();

        for (String student : presentStudents) {
            presentSet.add(student);
        }

        for (String student : allStudents) {
            if (!presentSet.contains(student)) {
                return student;
            }
        }

        return "";
    }
}
