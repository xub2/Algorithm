import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int whiteChess[] = {1,1,2,2,2,8}; // 킹, 퀸, 룩, 비숍, 나이트, 폰 개수

        int whiteChessInput[] = new int[whiteChess.length]; //동혁이가 찾은 체스말을 저장

        for(int i = 0 ; i < whiteChess.length ; i++){ // 여기서 동혁이가 찾은 체스말을 입력받음
            whiteChessInput[i] = sc.nextInt();
        }

        for(int i = 0 ; i < whiteChess.length; i++){
            if(whiteChess[i] == whiteChessInput[i]){
                System.out.println(0);
            }
            else{
                System.out.println(whiteChess[i] - whiteChessInput[i]);
            }
        }
            

        sc.close();


    }
}