package dingcorithm.week_2.homework;


public class ReturnKthElementWithLinkedListV2 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new Node(6));

        linkedList.append(new Node(7));
        linkedList.append(new Node(8));
        linkedList.append(new Node(9));
        linkedList.append(new Node(10));

        System.out.println(linkedList.getKthElement(2));
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {

        Node headNode;

        public LinkedList(Node node) {
            this.headNode = node;
        }

        public void append(Node node) {
            Node currentNodePointer = headNode;

            while (currentNodePointer.next != null) {
                currentNodePointer = currentNodePointer.next;
            }

            currentNodePointer.next = node;
        }

        public int getKthElement(int k) {
            // 먼저 마지막 노드까지 가야함
            // node.next == null 일때까지
            Node currentNodePointer = headNode;



            return 0;
        }


    }
}
