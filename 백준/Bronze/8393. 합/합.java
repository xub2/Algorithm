import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a = 0; // 누적 합을 위한 변수 초기화
        
        for(int i = 1; i <= n ; i++){ // 여기서 누적합을 위하여 n을 포함해야함 
            a = a + i;
        }
        
        
        System.out.println(a);
        
        sc.close();
        
    }
}