import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 두 수를 공백으로 구분하여 입력받음
        String[] input = sc.nextLine().split(" ");
        String A = input[0];
        String B = input[1];

        // 숫자를 뒤집음
        String reversedA = new StringBuilder(A).reverse().toString();
        String reversedB = new StringBuilder(B).reverse().toString();

        // 뒤집힌 숫자를 비교하여 큰 값 출력
        int intA = Integer.parseInt(reversedA);
        int intB = Integer.parseInt(reversedB);

        if (intA > intB) {
            System.out.println(intA);
        } else {
            System.out.println(intB);
        }

    }
}
