package dingcorithm.week_4.bfs;

import java.util.*;

public class BfsQueueV2 {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(1, 5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, Arrays.asList(1, 8));
        graph.put(5, Arrays.asList(2, 9));
        graph.put(6, Arrays.asList(3, 10));
        graph.put(7, Arrays.asList(3));
        graph.put(8, Arrays.asList(4));
        graph.put(9, Arrays.asList(5));
        graph.put(10, Arrays.asList(6));
    }

    private static List<Integer> bfsQueue(Map<Integer, List<Integer>> graph, int startIndex) {
        List<Integer> visited = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            Integer currentIndex = queue.poll();
            visited.add(currentIndex);

            List<Integer> currentIndexValueList = graph.get(currentIndex);

            for (Integer index : currentIndexValueList) {
                if (!visited.contains(index)) {
                    queue.offer(index);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        System.out.println(bfsQueue(graph, 1));
    }
}
