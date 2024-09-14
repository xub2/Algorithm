import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 1000 - sc.nextInt();
        int count = 0;
        int[] coinType = {500, 100, 50, 10 ,5, 1};

        for (int i = 0 ; i < coinType.length ; i++){
            int coin = coinType[i]; // 동전을 하나씩 꺼낸다
            count += N / coin; // 동전의 몫만큼 count 증가
            N = N % coin; // N에는 이제 나머지 값을 저장
        }

        System.out.println(count);

    }
}