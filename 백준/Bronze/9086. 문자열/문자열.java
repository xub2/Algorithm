import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =0; i < T; i++){
            String text = br.readLine();
            System.out.println(text.charAt(0)+ "" +text.charAt(text.length()-1));
        }
    }
}