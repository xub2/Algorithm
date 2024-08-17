import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int Array[] = new int[9];
        int max = 0;
        int n  = 0; // 인덱스를 저장할 변수

        for (int i = 0; i < 9; i++) {
            Array[i] = sc.nextInt();
            

            if(Array[i] > max){
                max = Array[i]; //최대 값을 구하기
                n = i + 1; //1 부터 시작하여 인데스 저장
            }
        }
        sc.close();
        System.out.println(max);
        System.out.println(n);


    }


    }

