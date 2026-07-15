package dingcorithm.week_2.recursive;

import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(input.length());

        ArrayList<String> list = new ArrayList<>();
        for (String s : input.split("")) {
            list.add(s);
        }

        System.out.println("== Two Pointer 사용 ==");
        System.out.println(isPalindromeTwoPointer(input));

        System.out.println("== Recursive + 인덱스 조작 사용 ==");
        System.out.println(isPalindromeRecursive(list, 0, list.size() - 1));

        System.out.println("== Recursive + substring() 사용 ==");
        System.out.println(isPalindromeRecursiveSubString(input));
    }

    // 맨 앞, 맨 뒤, 가운데 글자는 뭐가 오던 상관 없다
    // a b c b a
    private static boolean isPalindromeTwoPointer(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }

        return true;

    }

    /**
     * 재귀함수로도 펠린드롬 판별기를 구현할 수 있다
     * 재귀 함수의 특징으로는 점점 검색 범위를 줄여나간다는 특징이 있는데,
     * 이때 a b c b a 라는 문자열에 대해 제일 앞의 a와 제일 뒤의 a 가 같음을 알았다면 더이상 a b c b a 에 대해 볼 필요가 없다
     * 즉, a 두개를 제거하고 b c b 만 비교하면 된다.
     * <p>
     * 그럼 어떻게 풀면 될까?
     * 자바에서는 문자열을 잘라서 그 사이만 가져오는 기능따윈 없으므로 링크드 리스트를 쓰면 되나? -> 있어 병신아 그냥 charAt() 쓰면 됨 그리고
     * 아니면 배열 리스트를 써?
     */

    private static boolean isPalindromeRecursive(List<String> list, int left, int right) {
        // 모든 비교가 끝나거나 중앙에 도달하면 true
        if (left >= right) {
            return true;
        }

        // 양 끝이 다르면 바로 false
        if (!list.get(left).equals(list.get(right))) {
            return false;
        }

        // 범위 좁히기
        return isPalindromeRecursive(list, left + 1, right - 1);
    }

    private static boolean isPalindromeRecursiveSubString(String input) {
        if (input.length() <= 1) {
            return true;
        }

        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        } else {
            //substring 메서드의 파라미터는 (startIndex(포함), endIndex(불포함)) 이다
            return isPalindromeRecursiveSubString(input.substring(1, input.length() - 1));
        }

    }




}
