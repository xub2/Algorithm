import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int byear = in.nextInt();
        int syear = 543;
        
        System.out.println(byear - syear);
        
        in.close();
    }
}