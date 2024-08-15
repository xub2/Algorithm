import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 1;
        
        while(true){
            int n = sc.nextInt();
            
            if( n == 0)
                break;
            
            //홀수는 2로 안나눠짐~ 그러므로 나머지가 0이 아니라면
            if(n % 2 != 0){
                n = (((3 * n) + 1) / 2) * 3 / 9;
                System.out.println(count + ". odd " + n);
            }
            else{
                n = ((3 * n) / 2) *3 / 9;
                System.out.println(count + ". even " + n);
            }
            count++;
        }
    }
}