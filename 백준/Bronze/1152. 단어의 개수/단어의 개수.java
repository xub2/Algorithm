import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        solution(input);
    }

    public static void solution(String str) {

        String[] stringArray = str.split(" ");

//        System.out.println(Arrays.toString(stringArray));

        int count = 0;

        for (int i = 0; i < stringArray.length; i++) {
            if (!stringArray[i].isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
      }
}
