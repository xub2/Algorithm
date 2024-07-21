import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println(a*(b%10)); //385에서 380을 나눠주고 5만 남기기
        System.out.println(a*(b%100/10));//385에서 305을 나눠주고 80만 남기기
        System.out.println(a*(b/100));//385에서 85을 나눠주고 300만 남기기
        System.out.println(a*b);
    }
}