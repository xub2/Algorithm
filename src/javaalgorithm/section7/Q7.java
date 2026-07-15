package javaalgorithm.section7;

import java.io.*;
import java.util.*;

public class Q7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for (Point p : list) {
            bw.write(p.x + " " + p.y);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) { // 나를 상대보다 앞에 둘까
            if (this.x == o.x) { // 내 x 와 파라미터의 x 가 같다면
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }

    }
}
