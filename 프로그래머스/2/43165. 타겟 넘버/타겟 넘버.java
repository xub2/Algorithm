class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int curIndex, int sum) {
        if (curIndex == numbers.length) { // 끝까지 오고
            if (sum == target) { // 끝까지 왔을 때, 합이 target과 같다면 answer++
                answer++;
            }
            return;
        }

        dfs(numbers, target, curIndex + 1, sum + numbers[curIndex]);
        dfs(numbers, target, curIndex + 1, sum - numbers[curIndex]);
    }
}