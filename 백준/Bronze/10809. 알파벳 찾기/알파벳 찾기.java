import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];

        //일단 없는건 모두 -1로 처리하기전에 모든 배열을 -1로 초기화
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }


        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (alphabet[c - 'a'] == -1) {
                alphabet[c - 'a'] = i;
            }
        }


        for (int data : alphabet) {
            System.out.println(data + "");
        }



    }
}

