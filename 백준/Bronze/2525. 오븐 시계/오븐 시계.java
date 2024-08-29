import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int takeTime = sc.nextInt();
        
        min += takeTime; // 현재분과 걸린 시간을 더해준다
        
        //이때 걸린 min이 60분 이상이라면 min을 60으로 나눠서 시간을 증가시킨다
        if(min >= 60){ //이때 시계로는 59분까지만 표현 가능하므로 60을 포함
            hour = hour + min / 60;
            min = min % 60;
        }
        
        //00시도 고려해야하기 때문에 만약 시간이 24시를 넘어가면 00으로 초기화
        if(hour >= 24){ // 마찬가지로 시계는 23시까지 표현 가능하기 때문에 24를 포함
            hour = hour % 24;
        }
        sc.close();
        
        System.out.println(hour + " " + min);
    }
}