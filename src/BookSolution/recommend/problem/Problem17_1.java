package BookSolution.recommend.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem17_1 {

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = new int[]{7, 4, 5, 6};

        System.out.println(solution(bridgeLength, weight, truckWeights));
    }

    private static int solution(int bridgeLength, int weight, int[] truckWeights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentBridgeWeight = 0;
        int truckIndex = 0;

        for (int i = 0; i < bridgeLength; i++) {
            bridge.offer(0);
        }

        while (truckIndex < truckWeights.length) {
            time++;

            currentBridgeWeight -= bridge.poll();

            int nextTruck = truckWeights[truckIndex];
            if (currentBridgeWeight + nextTruck <= weight) {
                bridge.offer(nextTruck);
                currentBridgeWeight += nextTruck;
                truckIndex++;
            } else {
                bridge.offer(0);
            }
        }

        return time + bridgeLength;
    }

}
