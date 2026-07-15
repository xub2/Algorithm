package dingcorithm.week_2.homework;


public class ReturnKthElementWithLinkedList {

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
            // 여기 이제 구현

            Node currentNodePointer = headNode;
            int nodeTotalCount = 1;

            // head 부터 next 가 null일때 까지 카운트 ++
            while (currentNodePointer.next != null) {
                nodeTotalCount++;
                currentNodePointer = currentNodePointer.next;
            }

            int targetKthNodeIndex = nodeTotalCount - k;

            Node resultNode = headNode;
            for (int i = 0; i < targetKthNodeIndex; i++) {
                resultNode = resultNode.next;
            }

            return resultNode.data;
        }


    }
}
