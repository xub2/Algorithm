import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[10];
        int count = 0;

        // 42로 나눈 나머지를 배열에 저장
        for(int i = 0; i < 10; i++ ){
            arr[i] = sc.nextInt() % 42;
        }

        // 고유한 나머지 값을 찾기 위한 루프
        for(int i = 0; i < 10; i++ ){
            boolean same = false;
            for(int j = 0; j < i; j++ ){
                if(arr[i] == arr[j]){
                    same = true;
                    break; // 중복된 값이 있으면 루프 탈출
                }
            }
            if(!same){
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
