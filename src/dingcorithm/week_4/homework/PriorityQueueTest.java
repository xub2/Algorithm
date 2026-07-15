package dingcorithm.week_4.homework;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(100);
        heap.offer(1);
        heap.offer(64);
        heap.offer(33);

        System.out.println("heap = " + heap);


        PriorityQueue<Integer> heapReverse = new PriorityQueue<>(Collections.reverseOrder());
        heapReverse.offer(100);
        heapReverse.offer(1);
        heapReverse.offer(64);
        heapReverse.offer(33);

        System.out.println("heapReverse = " + heapReverse);
    }
}
