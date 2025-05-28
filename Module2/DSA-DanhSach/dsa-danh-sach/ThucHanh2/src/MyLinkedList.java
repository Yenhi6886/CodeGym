public class MyLinkedList<E> {
    // Node là lớp bên trong, đại diện cho mỗi phần tử (node) của danh sách
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private int numNodes = 0; // Số lượng phần tử trong danh sách
    private Node head = null; // Node đầu tiên của danh sách

    // Constructor khởi tạo danh sách với 1 node đầu tiên
    public MyLinkedList(E data) {
        head = new Node(data);
        numNodes = 1;
    }

    // Thêm phần tử vào cuối danh sách
    public void add(E data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    // Thêm phần tử vào đầu danh sách
    public void addFirst(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    // Lấy phần tử tại vị trí index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // In toàn bộ danh sách
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
