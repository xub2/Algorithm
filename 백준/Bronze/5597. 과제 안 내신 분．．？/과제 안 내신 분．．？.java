import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        boolean[] yes = new boolean[31]; //0번째 인덱스 사용 x
        
        for(int i = 0; i < 28; i++){
            int num = sc.nextInt();
            yes[num] = true;
        }
        
        for(int i =1; i <= 30; i++){
            if(!yes[i]){
                System.out.println(i);
            }
        }
        
        sc.close();
        
        
    }
}