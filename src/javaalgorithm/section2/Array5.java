package javaalgorithm.section2;

import java.io.*;

public class Array5 {

    public static void main(String[] args) throws IOException {

        // 소수 : 약수가 1과 자기 자신

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        // 배열을 일단 순서대로 쭉 채우고, 검증 로직 작성

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(solution(n)));
        bw.flush();
        bw.close();
    }

    private static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1]; // 인덱스 번호까지 만들어야함

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) { // i의 크기만큼 커져야 배수 체크 가능 예를 들어 i = 2 는 2씩 증가 해야함
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }
}
