package dingcorithm.week_3.stack;

public class StackDemo {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node head;

        public Stack() {
            this.head = null;
        }

        public void push(int value) {
            Node newHead = new Node(value); // [3] 이라는 노드를 만듦.
            newHead.next = this.head; // [3] -> [4]
            this.head = newHead; // [3] 이라는 노드를 head 로 만들어줘.
        }

        // pop 기능 구현
        public Node pop() {
            if (isEmpty()) {
                System.out.println("stack is Empty");
                return null;
            }
            Node deleteHead = this.head;
            this.head = this.head.next; // head = [3]
            return deleteHead;
        }

        public Object peek() {
            if (isEmpty()) {
                return "stack is Empty";
            }
            return this.head.data;
        }

        public boolean isEmpty() {
            return this.head == null;
        }
    }



    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}