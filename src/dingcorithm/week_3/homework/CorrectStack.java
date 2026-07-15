package dingcorithm.week_3.homework;

import java.util.*;

public class CorrectStack {

    public static void main(String[] args) {
        System.out.println(solution("()()")); // t
        System.out.println(solution(")()(")); // f

    }

    static boolean solution(String s) {
        Deque<Character> bracesStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                bracesStack.push(c);
            } else if (c == ')') {
                if (bracesStack.isEmpty()) {
                    return false;
                }

                bracesStack.pop();
            }
        }

        return bracesStack.isEmpty();

    }
}
