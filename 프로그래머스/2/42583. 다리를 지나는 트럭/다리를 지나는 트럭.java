import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentBridgeWeight = 0;
        int truckIndex = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (truckIndex < truck_weights.length) {
            time++;

            currentBridgeWeight -= bridge.poll();

            int nextTruck = truck_weights[truckIndex];
            if (currentBridgeWeight + nextTruck <= weight) {
                bridge.offer(nextTruck);
                currentBridgeWeight += nextTruck;
                truckIndex++;
            } else {
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }
}