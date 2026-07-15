package javaalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Machul {

    // n : 일수
    // k : 연속일 수
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt=0;

        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Machul M = new Machul();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> solution = M.solution(n, k, arr);

        for (int i : solution) {
            System.out.println(i + " ");
        }

    }
}
