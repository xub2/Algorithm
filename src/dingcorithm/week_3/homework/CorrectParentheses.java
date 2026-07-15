package dingcorithm.week_3.homework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Q. 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻이다. 예를 들어
 *
 * ()() 또는 (())() 는 올바르다.
 * )()( 또는 (()( 는 올바르지 않다.
 *
 * 이 때, '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 True 를 반환하고 아니라면 False 를 반환하시오.
 */
public class CorrectParentheses {

    public static void main(String[] args) {
        String correctParentheses = "(())()";
        String wrongParentheses = "((((";

        System.out.println(isParenthesesCorrect(correctParentheses));
        System.out.println(isParenthesesCorrect(wrongParentheses));

    }

    private static boolean isParenthesesCorrect(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') { // ( 면 무한 푸시 가능
                stack.push(c);
            } else if (c == ')') { // 만약 ) 인데 스택이 비어 있으면 바로 거짓
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop(); // ) 인데 스택이 비어 있지 않으면  ( 하나 제거 (pop)
            }
        }

        return stack.isEmpty();
    }

}
