package dingcorithm.week_4.dfs;

import java.util.*;

public class DfsStack {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, Arrays.asList(2, 5, 9));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, List.of(3));
        graph.put(5, Arrays.asList(1, 6, 8));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, List.of(6));
        graph.put(8, List.of(5));
        graph.put(9, Arrays.asList(1, 10));
        graph.put(10, List.of(9));
    }

    private static List<Integer> dfsStack(Map<Integer, List<Integer>> adjacentGraph, int startNode) {
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. 시작 노드 스택에 넣기
        stack.push(startNode);

        List<Integer> visited = new ArrayList<>();

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            visited.add(currentNode);

            for (int adjacentNode : adjacentGraph.get(currentNode)) {
                if (!visited.contains(adjacentNode)) {
                    stack.push(adjacentNode);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        System.out.println("dfsStack(graph, 1) = " + dfsStack(graph, 1));
    }
}
