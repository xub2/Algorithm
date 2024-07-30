import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        // 분이 45분보다 작으면
        if (M < 45) {
            H--;  // 시간을 1시간 줄이고
            M = 60 - (45 - M);  // 60분에서 (45 - M)만큼을 뺌
            
            // 시간이 음수이면 23시로 변경
            if (H < 0) {
                H = 23;
            }
        } else {
            M -= 45;  // 분이 45분 이상이면 45분을 뺌
        }
        
        System.out.println(H + " " + M);
        
        sc.close();
    }
}
