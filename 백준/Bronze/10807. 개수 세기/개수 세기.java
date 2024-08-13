import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력할 정수의 개수 입력
        int a = sc.nextInt();
        int array[] = new int[a]; //배열 크기는 여기서 결정한다 이눔시키야 왜 자꾸 반복문에서 찾아


        for (int i = 0; i < a; i++) { //a 만큼의 개수를 입력받기 위한 반복문
            array[i] = sc.nextInt(); // 여기서는 i 를 통해 각 주소별로 저장할 정수를 입력 받는다
        }

        int v = sc.nextInt(); // 찾고 싶은 수를 입력하는 변수
        int count = 0; // 최종 결과로 입력한 수가 몇개인지 표시하기 위한 변수

        for (int i = 0; i < a; i++){ // 여기서는 배열을 돌면서 배열안의 값과 v의 값이 같으면 count 를 1씩 증가
            if(array[i] == v){
                count++;
            }
        }
        sc.close(); // 메모리 효율을 위해 필수
        System.out.println(count);

    }
}
