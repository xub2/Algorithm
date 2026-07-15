package BookSolution.recommend.problem;

import java.util.*;

public class Problem30 {

    private static int[] parent;

    // 원소의 값이 인덱스
    // 부모 노드가 value

    // 파인드 연산 - 해당 노드의 부모 노드 찾기
    private static int find(int x) {
        if(parent[x] == x){ // parent[2] == 2 이라면 루트노드가 맞다
            return x;
        }

        // parent[0] = 2 면 0(자기 자신)이 루트 노드 아님
        // 그러면 자기 부모노드 따라가면서 찾아야 함
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // 유니온 연산 - 입력 받은 숫자 두개 합치기
    private static void union(int x, int y){
        // 집합의 루트 노드를 찾아야함
        int root1 = find(x);
        int root2 = find(y);

        parent[root2] = root1;
    }

    private static Boolean[] solution(int k, int[][] operation) {
        parent = new int[k];

        // 최초에는 노드가 자기 자신을 루트로 가지도록 한다
        for(int i = 0 ; i < parent.length; i++){
            parent[i] = i;
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) {
                // 0번 노드와 1번 노드를 합치고, 이어서 2번 노드까지 합치는 식으로 디버그 가능
                union(op[1], op[2]);
                union(op[2], op[3]);
                System.out.println("현재 parent 배열: " + Arrays.toString(parent));
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);

    }

    public static void main(String[] args) {
        // 노드 번호 3까지 고려한다면 k = 4가 되어야 함
        int k = 4;

        // 만약 한 줄에 숫자가 4개인 데이터를 처리하고 싶다면:
        // 예: {연산종류, 노드1, 노드2, 노드3}
        int[][] operations = {
                {0, 0, 1, 2} // 0번, 1번, 2번 노드를 모두 연관 짓고 싶을 때
        };

        System.out.println(Arrays.toString(solution(k, operations)));
    }
}
