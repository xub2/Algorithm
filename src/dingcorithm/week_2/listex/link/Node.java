package dingcorithm.week_2.listex.link;

public class Node {

    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node x = this;
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
