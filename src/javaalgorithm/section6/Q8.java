package javaalgorithm.section6;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q8 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 인덱스

        Deque<Person> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            Person person = new Person(i, Integer.parseInt(st.nextToken()));
            queue.offerLast(person);
        }

        while (!queue.isEmpty()) {

            boolean hasHigher = false;

            for (Person p : queue) {
                if (p.getDangerStatus() > queue.peekFirst().getDangerStatus()) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offerLast(queue.pollFirst());
            } else {
                answer++;
                Person treated = queue.pollFirst();

                if (treated.getIndex() == M) {
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Person {
        int index;
        int dangerStatus;

        private Person(int index, int dangerStatus) {
            this.index = index;
            this.dangerStatus = dangerStatus;
        }

        private int getIndex(){
            return index;
        }

        private int getDangerStatus() {
            return dangerStatus;
        }
    }
}
