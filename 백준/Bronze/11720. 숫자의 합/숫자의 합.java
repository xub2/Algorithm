import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int sum  = 0;
        String str = sc.next(); // 여기서 연결된 숫자를 일일히 쪼개서 계산하는것은 상당히 비효울적
        // 그러므로 한줄에 여러개 입력받는 것은 문자열을 통해서 풀고 그것을 아스키 -> 정수 or 정수 -> 아스키로 변환해주면 된다
        
        for(int i = 0 ; i < N; i++){
            sum = sum + str.charAt(i) - '0'; // 아스키코드를 정수로 변환해줘야 한다
    }
        sc.close();
        System.out.println(sum);
}}