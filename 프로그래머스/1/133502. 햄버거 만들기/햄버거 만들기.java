import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 재료를 쌓아둘 스택

        //스택에 재료(배열 원소) 를 하나씩 push
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]); // 재료를 스택에 넣기

            // 스택에 쌓인 재료가 4개 이상일 때 확인
            if (stack.size() >= 4) {
                int size = stack.size();
                //스택 아래서부터 재료 가져옴 그리고 1-2-3-1 순서가 맞는지 확인
                if (stack.get(size - 4) == 1 && 
                    stack.get(size - 3) == 2 && 
                    stack.get(size - 2) == 3 && 
                    stack.get(size - 1) == 1) {
                    
                    // 재료가 맞다면, 스택에서 4개의 재료를 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    // 햄버거를 하나 만들었으므로, 개수 증가
                    answer++;
                }
            }
        }
        
        return answer; // 포장된 햄버거 개수 반환
    }
}
