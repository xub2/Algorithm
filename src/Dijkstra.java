import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    private static int[] solution(int[][] graph, int start, int n) {
        List<Node>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프 정보 저장
        for (int[] edge : graph) {
            // [0,1,9] = 0번에서 1번까지 가는데 9만큼 가중치
            Node node = new Node(edge[1], edge[2]);
            adjList[edge[0]].add(node);
        }

        // 모든 노드 거리 값을 무한으로 초기화
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 시작 노드 거리 값 0으로 초기화
        dist[start] = 0;

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getCost(), o2.getCost()));

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();


        }

        return null;
    }
}
