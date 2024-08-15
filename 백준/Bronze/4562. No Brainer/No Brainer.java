import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            if (X < Y){
               System.out.println("NO BRAINS");
            }
            else{
               System.out.println("MMM BRAINS");
            }
        }
        sc.close();
    }
}