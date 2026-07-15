package javaalgorithm.section6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q7 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mustTake = br.readLine();
        String plan = br.readLine();

        String answer = "YES";

        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < mustTake.length(); i++) {
            queue.offerLast(String.valueOf(mustTake.charAt(i)));
        }

        for (int i = 0; i < plan.length(); i++) {
            if (queue.contains(String.valueOf(plan.charAt(i)))) {
                // 큐에 존재 한다면 큐 탐색 시작
                if (queue.peekFirst().equals(String.valueOf(plan.charAt(i)))) {
                    queue.pollFirst();
                } else {
                    answer = "NO";
                    break;
                }
            }
        }

        if (!queue.isEmpty()) {
            answer = "NO";
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }
}
