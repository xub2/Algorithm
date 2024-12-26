import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            String input = sc.next();

            if (Integer.parseInt(input) == 0) {
                break;
            }

            String reversed = new StringBuilder(input).reverse().toString();

            if (input.equals(reversed)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            } 
        }
    }


}