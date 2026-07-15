package javaalgorithm.section2;

import java.util.*;

public class Array1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArr = new int[n];

        for(int i = 0 ; i < n ; i++){
            inputArr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = solution(inputArr);
        for(int i : result){
            System.out.print(i + " ");
        }

    }

    private static ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);

        for(int i = 1 ; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                result.add(arr[i]);
            }
        }

        return result;

    }
}
