/* 최고점 70 , 받은 점수 50 이면 50 / 60 * 100 이 점수 구하는 방법이다 */
/* 그렇다면 공식은 
받은 점수 / 최고 점수 * 100 
*/
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int score[] = new int[N];
        int max = 0;
        double sum = 0.0;
        double av = 0.0;
        
        for(int i = 0 ; i < N ; i++){
            score[i] = sc.nextInt();
            if (score[i] > max){
                max = score[i]; // 여기서 최대 값
            }
        }
        
     
        
        for(int i = 0 ; i < N ; i++){
            double newScore = (double) score[i] / max * 100;
            sum += newScore;
            }
        
        av = sum / N;
        
        sc.close();
        System.out.println(av);
    }
}