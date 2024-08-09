import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String str = "";

        for(int i = 1; i < a / 4 ; i++ ){
            str = str + "long ";

        }
        sc.close();

        System.out.println(str + "long int");
    }
}