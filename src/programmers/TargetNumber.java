package programmers;

public class TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {

        if (idx == numbers.length) { // 0 ~ 4 번 인덱스까지 덧셈 뺄셈 완
            if (target == sum) {
                answer++; // 끝까지 왔을 떄 값이 찾는 값이면 정답++
            }

            return; // else 문에 넣으면 안되고 증가하고 바로 함수 종료해야함
            // 아니면 배열 범위 numbers(5)를 찔러봄 -> 없음
        }

        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        TargetNumber targetNumber = new TargetNumber();
        System.out.println(targetNumber.solution(numbers, target));

    }
}
