class Solution {

    public String solution(String phone_number) {
        String answer = "";

        for (int i = 0; i < phone_number.length(); i++) {   // a.
            if (i < phone_number.length() - 4)   // b.
                answer += "*";  // c.
            else
                answer += phone_number.charAt(i);   // d.
        }

        return answer;
    }
}

