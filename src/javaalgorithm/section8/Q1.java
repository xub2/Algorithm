package javaalgorithm.section8;

import java.util.Scanner;

public class Q1 {

    private static void recursive(int n) {
        if (n == 0) {
            return;
        } else {
            recursive(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        recursive(sc.nextInt());
    }
}
