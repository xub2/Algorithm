package dingcorithm.week_2.listex;

import java.io.*;
import java.util.LinkedList;

public class Josephus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        br.close();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        int index = 0;
        // 범위를 벗어나면 최초로 돌아온다 -> 시계를 보면 13시는 1시 , 14시는 2시 -> 현재 시간 / 12
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            result.append(list.remove(index));
            if (!list.isEmpty()) {
                result.append(", ");
            }
        }

        result.append(">");
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}