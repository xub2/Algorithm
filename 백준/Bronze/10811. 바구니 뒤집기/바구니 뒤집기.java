import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 바구니 개수
        int M = sc.nextInt(); // 역순으로 바꿀 횟수
        int basket[] = new int[N];

        // 바구니 번호를 초기화
        for (int i = 0; i < N; i++) {
            basket[i] = i + 1;
        }

        // M번에 걸쳐 바구니의 순서를 뒤집음
        for (int i = 0; i < M; i++) { // M번 반복
            int h = sc.nextInt() - 1; // 시작 인덱스
            int t = sc.nextInt() - 1; // 끝 인덱스

            // h부터 t까지 바구니를 뒤집음
            while (h < t) {
                int temp = basket[h];
                basket[h] = basket[t];
                basket[t] = temp;
                h++;
                t--;
            }
        }

        // 최종 바구니의 상태를 출력
        for (int i = 0; i < N; i++) {
            System.out.print(basket[i] + " ");
        }
        sc.close();
    }
}
