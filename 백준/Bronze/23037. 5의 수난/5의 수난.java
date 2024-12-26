import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String[] array = input.split("");

        int[] answerArray = new int[array.length];

        long sum = 0;

        for (int i = 0; i < array.length; i++) {
            answerArray[i] = Integer.parseInt(array[i]);
        }

        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = (int) Math.pow(answerArray[i], 5);
            sum += answerArray[i];
        }

        System.out.println(sum);

    }

}