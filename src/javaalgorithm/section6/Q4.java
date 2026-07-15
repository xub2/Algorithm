package javaalgorithm.section6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals("+")
                    || String.valueOf(input.charAt(i)).equals("-")
                    || String.valueOf(input.charAt(i)).equals("*")
                    || String.valueOf(input.charAt(i)).equals("/")) {

                int top = Integer.parseInt(stack.pop());
                int bot = Integer.parseInt(stack.pop());

                int sum = 0;

                if (input.charAt(i) == '+') {
                    sum += (bot + top);
                } else if (input.charAt(i) == '-') {
                    sum += (bot - top);
                } else if (input.charAt(i) == '*') {
                    sum += (bot * top);
                } else {
                    sum += (bot / top);
                }

                stack.push(String.valueOf(sum));

            } else {
                stack.push(String.valueOf(input.charAt(i)));
            }
        }

        bw.write(String.valueOf(stack.pop()));

        bw.flush();
        bw.close();
        br.close();
    }
}
