import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Node(i, priorities[i]));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            boolean hasHigher = false;
            for (Node n : queue) {
                if (current.getValue() < n.getValue()) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current); // 뒤로 재삽입
                continue;
            }

            // 현재 노드가 최우선순위 → 소비
            count++;
            if (current.getIndex() == location) {
                return count;
            }
        }

        return count;
    }

    static class Node {
        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}