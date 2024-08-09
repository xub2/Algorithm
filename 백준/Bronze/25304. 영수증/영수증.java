import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();// 총합 가격
        int N = sc.nextInt(); // 총 물건 개수
        int total = 0; // 누적합


        for (int i = 0 ; i < N ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            total = total + (a*b);

            }

        if (total == X)
            System.out.println("Yes");
        else
            System.out.println("No");

        sc.close();

        }

       
    }
