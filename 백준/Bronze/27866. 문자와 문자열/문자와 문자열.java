import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int i = sc.nextInt() - 1; // 0 번째부터 시작하기 때문에 -1

        System.out.println(S.charAt(i));
    }
}