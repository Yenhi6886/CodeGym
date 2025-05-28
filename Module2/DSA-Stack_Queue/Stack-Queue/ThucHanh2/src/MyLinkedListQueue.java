public class MyLinkedListQueue {
    private Node head; // phần tử đầu hàng đợi (sẽ bị xóa đầu tiên)
    private Node tail;  // phần tử cuối hàng đợi (sẽ được thêm vào)

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);     // tạo node mới
        if (this.tail == null) {       // nếu queue rỗng
            this.head = temp;
            this.tail = temp;
            return;
        }
        this.tail.next = temp;         // trỏ phần tử cuối hiện tại đến phần tử mới
        this.tail = temp;              // cập nhật phần tử cuối mới
    }

    public Node dequeue() {
        if (this.head == null) {
            return null;               // nếu queue rỗng thì trả về null
        }
        Node temp = this.head;        // lưu phần tử đầu để trả về
        this.head = this.head.next;   // cập nhật head sang phần tử kế tiếp
        if (this.head == null) {
            this.tail = null;         // nếu không còn phần tử thì tail cũng null
        }
        return temp;
    }

}
