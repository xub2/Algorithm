package javaalgorithm.section6;

import java.util.*;
import java.io.*;

public class Q6 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            for (int i = 0; i < K - 1; i++) {
                queue.offerLast(queue.pollFirst());
            }

            queue.pollFirst();
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}
