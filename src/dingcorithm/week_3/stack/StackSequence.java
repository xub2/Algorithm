package dingcorithm.week_3.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackSequence {

    static final String PUSH = "+";
    static final String POP = "-";
    static final String NO = "NO";

    //4, 3, 6, 8, 7, 5, 2, 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        int start = 0;

        int n = sc.nextInt();//8

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            // 목표 숫자가 더 크면, 해당 숫자까지 push 하고 start 업데이트
            if (target > start) {
                for (int j = start + 1; j <= target; j++) {
                    stack.push(j);
                    sb.append(PUSH + "\n");
                }
                start = target;
            }

            // 다 채웠는데 맨 위 숫자가 목표랑 다르면 return
            if (stack.peek() != target) {
                System.out.println(NO);
                return;
            }

            // 맨 위 숫자랑 목표랑 같으면 pop
            stack.pop();
            sb.append(POP + "\n");
        }

        System.out.println(sb);
    }
}
