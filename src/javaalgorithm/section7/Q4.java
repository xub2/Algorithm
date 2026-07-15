package javaalgorithm.section7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// LRU = 가장 오랫동안 사용하지 않은 것을 지우겠다

public class Q4 {

    private static int S, N;
    private static int[] cache;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // 캐시 크기
        N = Integer.parseInt(st.nextToken()); // 작업수

        cache = new int[S];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int jobNum = Integer.parseInt(st.nextToken());
            boolean isCacheMiss = true;
            int index = -1;

            // hit 면 인덱스 저장
            for (int j = 0; j < cache.length; j++) {
                if (cache[j] == jobNum) {
                    isCacheMiss = false;
                    index = j;
                    break;
                }
            }

            if (isCacheMiss) { // 캐시에 실행하고자 하는 게 없으면 나머지를 뒤로 밀고 제일 앞에 하고자 하는 작업 번호 넣기
                // 1. shift
                for (int k = cache.length - 1; k >= 1; k--) {
                    cache[k] = cache[k - 1];
                }
                cache[0] = jobNum;

            } else { // 캐시에 jobNum이 존재한다면 ?
                for (int k = index; k >= 1; k--) { // 2번 인덱스에서 찾았다면 0번, 1번 인덱스를 밀어야 함
                    cache[k] = cache[k - 1];
                }
                cache[0] = jobNum;
            }
        }

        for (int i : cache) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
