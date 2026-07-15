package javaalgorithm.section6;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> stack = new ArrayDeque<>();

        String input = br.readLine();

        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) != ')') {
                stack.push(String.valueOf(input.charAt(i)));
            } else {
                while (!stack.peek().equals("(")) {
                    stack.pop();
                }
                stack.pop();
            }

            i++;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
