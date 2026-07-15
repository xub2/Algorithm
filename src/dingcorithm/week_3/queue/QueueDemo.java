package dingcorithm.week_3.queue;

public class QueueDemo {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        private Node head;
        private Node tail;

        public Queue() {
            this.head = null;
            this.tail = null;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
                return;
            }

            this.tail.next = newNode;
            this.tail = newNode;
        }

        public Node dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }

            Node deleteHead = this.head;
            this.head = this.head.next;

            return deleteHead;
        }

        public Object peek() {
            if (isEmpty()) {
                return "Queue is empty";
            }

            return this.head.data;
        }

        public boolean isEmpty() {
            return this.head == null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(4);
        System.out.println(queue.peek());
        queue.enqueue(2);
        System.out.println(queue.peek());
        queue.enqueue(3);
        System.out.println(queue.peek());

        queue.dequeue();
        System.out.println(queue.peek());

        queue.dequeue();
        System.out.println(queue.peek());

        queue.dequeue();
        System.out.println(queue.peek());
    }
}
