class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1]; // 1 base 로 시작 / index 번호를 사용할 예정이기 때문에 이렇게 해야 n번숫자만큼 index가 나옴
        
        // 모든 수를 소수로 초기화 (true) ->
        for(int i = 2 ; i <= n; i++){
            isPrime[i] = true;
        }
        
        // 2부터 자기의 배수인 것들을 모두 false로 변경 / 최초에 2는 소수라고 가정하고 시작
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                answer++;
                for(int j = i ; j <= n ;j = j + i){ // 1번째 반복 예시 : j가 2부터 10까지 j + i 면 2의 배수만큼 이동하면서 false로 변경
                    isPrime[j] = false;
                }   
            } 
        }
        
        return answer;
    }
}

// 소수 :  약수가 1과 자기 자신
// 1과 n 사이에 있는 소수 개수 반환하기

// n = 10 , result = {2, 3, 5, 7}