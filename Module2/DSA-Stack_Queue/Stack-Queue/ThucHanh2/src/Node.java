public class Node {
    public int key;       // dữ liệu của node
    public Node next;     // trỏ đến node kế tiếp

    public Node(int key) {
        this.key = key;
        this.next = null; // ban đầu chưa trỏ đến ai
    }
}
