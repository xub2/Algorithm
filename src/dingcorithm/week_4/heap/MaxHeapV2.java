package dingcorithm.week_4.heap;

import java.util.*;

public class MaxHeapV2 {

    List<Integer> items;

    public MaxHeapV2(){
        this.items = new ArrayList<>();
        this.items.add(null); // 0 번째 인덱스 안쓸거임
    }

    /**
     * 부모 구하는 공식 : 좌우 상관 없이 N / 2
     */

    private static void printWithPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        queue.add(8);
        queue.add(6);
        queue.add(7);
        queue.add(5);
        queue.add(2);
        queue.add(4);


        System.out.println("내림차순 우선 순위 큐");
        System.out.println(queue);

        queue.poll();

        System.out.println(queue);
    }

    public void insert(int value) {
        items.add(value);
        int currentIndex = this.items.size() - 1;

        while (currentIndex != 1) {

            int parentIndex = currentIndex / 2;

            if (this.items.get(currentIndex) > this.items.get(parentIndex)) {
                int temp = items.get(currentIndex);
                items.set(currentIndex, items.get(parentIndex));
                items.set(parentIndex, temp);

                currentIndex = parentIndex; // 삽입한 데이터가 부모의 인덱스가 됨
            } else {
                break;
            }
        }
    }

    // 힙의 제거는 루트 값을 제거하는 것
    public int delete() {

        // swap 안해도 됨
        int result = this.items.get(1);

        int lastIndex = this.items.size() - 1;

        this.items.set(1, this.items.get(lastIndex));

        // 반드시 지워줘야 함
        this.items.remove(lastIndex);

        // 좌, 우측 자식 노드 구하는 법?
        // 좌 : i * 2
        // 우 : i * 2 + 1

        int currentIndex = 1;

        while (true) {
            int leftChildIndex = currentIndex * 2;
            int rightChildIndex = currentIndex * 2 + 1;

            int largestIndex = currentIndex;

            if (leftChildIndex < this.items.size()
                    && this.items.get(leftChildIndex) > this.items.get(largestIndex)) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < this.items.size()
                    && this.items.get(rightChildIndex) > this.items.get(largestIndex)) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex == currentIndex) {
                break;

            }

            int temp = this.items.get(currentIndex);
            this.items.set(currentIndex, this.items.get(largestIndex));
            this.items.set(largestIndex, temp);

            currentIndex = largestIndex;
        }

        return result;
    }


    public static void main(String[] args) {
        MaxHeapV2 maxHeap = new MaxHeapV2();
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        System.out.println(maxHeap.items); // [null, 8, 6, 7, 2, 5, 4]
        System.out.println(maxHeap.delete()); // 8 을 반환해야 합니다!
        System.out.println(maxHeap.items); // [null, 7, 6, 4, 2, 5]
        System.out.println();

        printWithPriorityQueue();
    }
}
