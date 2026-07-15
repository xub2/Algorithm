package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem10 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
        System.out.println(solution("}]()[{")); // 3
        System.out.println(solution("[)(]")); // 0
        System.out.println(solution("}}}")); // 0
    }

    private static int solution(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // 시작 인덱스와 끝 인덱스가 같으면 빈 문자열을 반환한다.
            String rotated = s.substring(i) + s.substring(0, i); // 파라미터가 하나면 해당 인덱스부터 끝까지 O(N + M)

            if (isValid(rotated)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                // 닫는 괄호인데 스택이 비어있으면 false
                if (stack.isEmpty()) {
                    return false;
                }

                // 스택이 뭐라도 차있으면
                char peek = stack.peek();

                if ((c == ']' && peek == '[') ||
                        (c == '}' && peek == '{') ||
                        (c == ')' && peek == '(')) {
                    stack.pop();
                } else {
                    // 괄호가 열고 닫는 짝이 안맞아도 실패
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
