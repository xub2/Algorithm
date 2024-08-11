import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 1 ; i <= T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = a+b;

            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + c); // 이거 풀때 문제 좀 잘 읽어라 문제에서 A+B=C 로 나타내라고 했으니까 변수 하나 추가해야함
        }
        sc.close();

    }
}
