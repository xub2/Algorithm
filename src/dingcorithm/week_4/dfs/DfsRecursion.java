package dingcorithm.week_4.dfs;

import java.util.*;

public class DfsRecursion {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static List<Integer> visited = new ArrayList<>();

    static {
        graph.put(1, Arrays.asList(2, 5, 9));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3));
        graph.put(5, Arrays.asList(1, 6, 8));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, Arrays.asList(6));
        graph.put(8, Arrays.asList(5));
        graph.put(9, Arrays.asList(1, 10));
        graph.put(10, Arrays.asList(9));
    }

    private static void dfsRecursion(Map<Integer, List<Integer>> adjacentGraph, int currentNode, List<Integer> visitedArray) {
        visitedArray.add(currentNode); // 내가 방문한 노드는 currentNode 이다. -> 일단 자신을 방문기록에 기록

        // 인접 노드 중 방문하지 않은 노드를 방문한다. -> 그리고 인접 노드에 다시 방문
        for (int adjacentNode : adjacentGraph.get(currentNode)) {
            if (!visitedArray.contains(adjacentNode)) {
                dfsRecursion(adjacentGraph, adjacentNode, visitedArray);
            }
        }
    }


    public static void main(String[] args) {
        dfsRecursion(graph, 1, visited);
        System.out.println(visited); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 이 출력되어야 합니다!
    }
}
