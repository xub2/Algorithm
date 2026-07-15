package dingcorithm.week_5;

import java.util.ArrayDeque;
import java.util.Deque;

public class CorrectParentheses {

    public static void main(String[] args) {
        String w = "()))((()";
        System.out.println(getCorrectParentheses(w));
    }

    private static String getCorrectParentheses(String parenthesesString) {
        if (isCorrectParentheses(parenthesesString)) {
            return parenthesesString;
        } else {
            return changeBalancedParenthesesToCorrectParentheses(parenthesesString);
        }
    }

    // 올바른 괄호가 아닐 때 -> 균형잡힌 괄호 문자열일 때 올바른 괄호 문자열로 마이그레이션
    private static String changeBalancedParenthesesToCorrectParentheses(String w) {
        // 1. 입력이 빈문자면 빈 문자열 출력
        if (w.equals("")) {
            return "";
        }

        // 2. 문자열 w를 균형 잡힌 문자열 2개로 분리 -> 즉 분리한 두 문자열이 모두 '(' 와 ')' 개수가 같아야함
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < w.length(); i++) {
            queue.offer(w.charAt(i));
        }

        int leftParenthesesCount = 0;
        int rightParenthesesCount = 0;

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        while (!queue.isEmpty()) {
            Character polled = queue.poll();
            u.append(polled);

            if (polled == '(') {
                leftParenthesesCount++;
            } else {
                rightParenthesesCount++;
            }

            if (leftParenthesesCount == rightParenthesesCount) {
                break;
            }
        }

        // v 채우기
        while (!queue.isEmpty()) {
            v.append(queue.poll());
        }

        if (isCorrectParentheses(u.toString())) {
            return u + changeBalancedParenthesesToCorrectParentheses(v.toString());
        } else { // u가 올바른 괄호 문자열이 아니라면? -> 완전히 새로운 문자열 만들어야 함
            return createNewParenthesesString(u.toString(),v.toString());
        }

    }

    private static String reverseStringU(String u) {
        String targetToReverse = u.substring(1, u.length() - 1);
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < targetToReverse.length(); i++) {
            if (targetToReverse.charAt(i) == '(') {
                reversed.append(")");
            } else {
                reversed.append("(");
            }
        }

        return reversed.toString();
    }

    private static String createNewParenthesesString(String u, String v) {
        StringBuilder newString = new StringBuilder();
        newString.append("(");

        // v에 대한 재귀 붙이기
        newString.append(changeBalancedParenthesesToCorrectParentheses(v));

        newString.append(")");

        newString.append(reverseStringU(u));

        return newString.toString();
    }

    // 올바른 괄호인지 판단
    private static boolean isCorrectParentheses(String parentheses) {
        Deque<Character> stack = new ArrayDeque<>();

        // 7번 반복
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') { // ) 인데 스택이 비어있으면 X
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }
}
