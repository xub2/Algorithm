package javaalgorithm.section1;

import java.util.Scanner;

public class String2 {

    public static String Solution(String string) {
        char[] charArray = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            } else {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }

            sb.append(charArray[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(Solution(str));
    }
}
