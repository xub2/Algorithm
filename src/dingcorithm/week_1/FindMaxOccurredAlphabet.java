package dingcorithm.week_1;


public class FindMaxOccurredAlphabet {

    public static void main(String[] args) {

        System.out.println("====findMaxOccurredAlphabetV0====");
        System.out.println("정답 = i 현재 풀이 값 = " + findMaxOccurredAlphabetV0("hello my name is dingcodingco"));
        System.out.println("정답 = e 현재 풀이 값 = " + findMaxOccurredAlphabetV0("we love algorithm"));
        System.out.println("정답 = b 현재 풀이 값 = " + findMaxOccurredAlphabetV0("best of best youtube"));
        System.out.println("====findMaxOccurredAlphabetV1====");
        System.out.println("정답 = i 현재 풀이 값 = " + findMaxOccurredAlphabetV1("hello my name is dingcodingco"));
        System.out.println("정답 = e 현재 풀이 값 = " + findMaxOccurredAlphabetV1("we love algorithm"));
        System.out.println("정답 = b 현재 풀이 값 = " + findMaxOccurredAlphabetV1("best of best youtube"));
    }

    static String findMaxOccurredAlphabetV0(String string) {
        // 문자열을 먼저 쪼개 봅시다
        String[] arr = string.split("");

        // 알파벳을 카운팅할 배열도 만듭시다
        // a = 0 , b = 1 , c = 2 ... z = 25
        int[] alpha = new int[26];

        // 공백도 제거 해야겠지요? -> 빌더 타입을 씁시다
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            if (!s.equals(" ")) {
                sb.append(s);
            }
        }

        char[] temp = sb.toString().toCharArray();

        // 이제 아스키 코드로 다시 풀어볼게요 -> 97 빼기
        for (char c : temp) {
            int index = c - 97;
            alpha[index]++;
        }

        // 그럼 이제 순회 하면서 가장 많이 있는 알파벳을 찾아봐요

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                maxIndex = i;
            }
        }

        char result = (char) (maxIndex + 97);
        return String.valueOf(result);
    }

    static String findMaxOccurredAlphabetV1(String string) {
        // 알파벳 매핑 배열
        int[] alphabetOccurrence = new int[26];

        char[] array = string.toCharArray();
        for (char c : array) {
            if (Character.isAlphabetic(c)) {
                int index = c - 97;
                alphabetOccurrence[index]++;
            }
        }

        int maxOccurrence = 0;
        int maxAlphabetIndex = 0;

        for (int i = 0; i < alphabetOccurrence.length; i++) {
            if (alphabetOccurrence[i] > maxOccurrence) {
                maxOccurrence = alphabetOccurrence[i];
                maxAlphabetIndex = i;
            }
        }

        return String.valueOf((char) (maxAlphabetIndex + 97));
    }
}

