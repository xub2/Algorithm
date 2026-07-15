package BookSolution.recommend.problem;

import java.util.*;

public class Problem19 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String string : completion) {
            // 키는 (이름 : 사람 명수)로 한다
            // 키에 대해 map에 존재하지 않으면, default 값으로 0일 들어간다. -> 그리고 최초 등장이니까 + 1
            // 만약 존재하는 이름(키) 라면, 해당 키의 값을 가져온다. 있다면 1을 가져오고 + 1이 됨
            // 정리하면 처음 등장하는 이름은 1 / 그렇지 않고 이미 있는 키값이라면 해당 키값을 가져와서 + 1
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        for (String string : participant) {
            if (map.getOrDefault(string, 0) == 0) {
                return string;
            }

            map.put(string, map.get(string) - 1);
        }

        return "모두 완주 하였습니다.";
    }

    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        System.out.println(problem19.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));

    }
}
