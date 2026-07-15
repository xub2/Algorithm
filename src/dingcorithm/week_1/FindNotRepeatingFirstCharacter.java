package dingcorithm.week_1;

import java.util.Arrays;

public class FindNotRepeatingFirstCharacter {

    public static void main(String[] args) {
        System.out.println("정답 = d 현재 풀이 값 = " + findNotRepeatingFirstCharacter("abadabac"));
        System.out.println("정답 = c 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println("정답 = _ 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aaaaaaaa"));
    }

    // 반복되지 않는 첫번째 문자 -> 아스키 코드?
    static String findNotRepeatingFirstCharacter(String string) {
        char[] arr = string.toCharArray();
        int[] alphabet = new int[26];

        for (char c : arr) {
            alphabet[c - 'a']++;
        }

        for (char c : arr) {
            if (alphabet[c - 'a'] == 1) {
                return String.valueOf(c);
            }
        }

        return "_";

    }

}
