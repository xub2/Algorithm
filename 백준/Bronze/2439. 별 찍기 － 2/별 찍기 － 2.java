import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();


        for(int i = 1 ; i <= N ; i++){ //행반복
            for(int j = 1; j <= N - i ; j++){ // 공백 반복 + 별은 행 만큼 증가하니 N - i(행) 의 값으로 공백을 출력해주어야함
                System.out.print(" ");
            }
            for(int k = 1; k <= i ; k++){ // 별반복
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }

    }
}