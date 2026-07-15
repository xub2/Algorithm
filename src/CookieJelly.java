public class CookieJelly {

    // 이미 얼음이면 넘어간다
    // 노랑 -> 분홍 -> 얼음 -> 노랑 -> ...
    public int solution(String bears, int K) {
        char[] bearsToArr = bears.toCharArray();
        int count = 0;

        for (int i = 0; i < bearsToArr.length - K + 1; i++) {
            // 일단 얼음곰젤리면 넘어간다

            while (bearsToArr[i] != 'I') {

                for (int j = i; j < i + K; j++) {

                    if (bearsToArr[j] == 'Y') {
                        bearsToArr[j] = 'P';
                    } else if (bearsToArr[j] == 'P') {
                        bearsToArr[j] = 'I';
                    } else {
                        bearsToArr[j] = 'Y';
                    }

                }

                // for 문은 i ~ i + K - 1 범위까지 젤리를 변화 시키기 위함이다.
                // 그래서 for문이 끝나면 1회 시약을 던진 것으로 구현한다.
                count++;
            }
        }

        for (char c : bearsToArr) {
            if (c != 'I') {
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CookieJelly cookieJelly = new CookieJelly();
        int answer = cookieJelly.solution("PPY", 2);
        System.out.println(answer);
    }

}
