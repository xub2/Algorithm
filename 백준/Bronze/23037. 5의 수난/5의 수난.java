import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        int man = N / 10000;
        man = (int) Math.pow(man,5);

        int chun = (N % 10000) / 1000;
        chun = (int) Math.pow(chun,5);

        int baek = ((N % 10000) % 1000) / 100;
        baek = (int) Math.pow(baek,5);

        int sip = (((N % 10000) % 1000) % 100) / 10 ;
        sip = (int) Math.pow(sip,5);

        int il = (((N % 10000) % 1000) % 100) % 10;
        il = (int) Math.pow(il,5);

        System.out.print(man+chun+baek+sip+il);


    }
}