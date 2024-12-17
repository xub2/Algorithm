import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int quarter = 25;
    static int dime = 10;
    static int nickel = 5;
    static int penny = 1;

    public static void main(String[] args) {

        int t = sc.nextInt();

        int quarter_count = 0;
        int dime_count = 0;
        int nickel_count = 0;
        int penny_count = 0;

        for (int i = 0; i < t; i++) {
            int change = sc.nextInt();

            quarter_count = change/quarter;
            change = change % quarter;

            dime_count = change / dime;
            change = change % dime;

            nickel_count = change / nickel;
            change = change % nickel;

            penny_count = change / penny;


            System.out.println(quarter_count + " " + dime_count + " " + nickel_count + " " + penny_count);

        }
    }
}