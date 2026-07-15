package dingcorithm.week_2.listex.link;

public class MyLinkedList<E> {

    private Node<E> first;
    private int size = 0;

    // 최초 노드가 비어있으면 새로 추가 , 아니라면 맨뒤에 이어 붙이기
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    // 마지막 노드를 찾는 방법은 결국 처음부터 끝까지 뒤지는 법
    private Node<E> getLastNode() {
        Node<E> lastNode = first;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    // 특정 부분에 노드를 추가하려면? -> 가장 앞에 , 가장 앞이 아니라면 -> 두가지 조건을 구현
    private void add(int index, E e) {
        Node<E> newNode = new Node<>(e);

        // 첫번째에 추가한다면? -> index = 0
        // 추가하는 노드의 next에 현재 첫번째 노드의 주소를 넣어주면 된다
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next; // 기존이 가르키고 있던 다음 노드를 이제 얘가 가르켜야함
            prev.next = newNode;
        }

        size++;
    }

    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.data;
        x.data = element;
        return oldValue;
    }

    public void remove(int index) {
        // 지우고 싶은 노드
        Node<E> removeNode = getNode(index);

        if (index == 0) {
            // 첫번째 노드가 가르키고 있던 두번째 노드가 첫번째 노드가 됨
            first = removeNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }

        makeNodeNull(removeNode);
        size--;
    }

    private void makeNodeNull(Node<E> removeNode) {
        removeNode.data = null;
        removeNode.next = null;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node.data;
    }

    public Node<E> getNode(int index) {
        Node<E> x = first; // 항상 알고있느 노드는 Head 노드 뿐
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> x = this;
            sb.append("[");

            while (x != null) {
                sb.append(x.data);
                if (x.next != null) {
                    sb.append("->");
                }
                x = x.next;
            }

            sb.append("]");
            return sb.toString();
        }
    }


}
