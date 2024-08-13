import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int array[] = new int[N];

        for (int i = 0; i < N; i++) { // 배열에 정수를 입력하기 위해서는 항상 반복문 조심
            array[i] = sc.nextInt(); // 또한 입력 받을 때 배열의 레퍼런스(i) 입력하는 것 필수
        }

        int max = array[0];
        int min = array[0];

        for(int i = 0; i < N ; i++){
            if(array[i] < max){
                max = array[i];
            }

            if(array[i] > min){
                min = array[i];
            }

        }
            sc.close();
            System.out.print(max + " ");
            System.out.print(min);
        }
    }


