public class Solution {
    Queue q = new Queue();

    // Thêm phần tử vào queue
    public void enQueue(int value) {
        Node temp = new Node(value);

        // Nếu hàng đợi trống
        if (q.front == null) {
            q.front = q.rear = temp;
            q.rear.link = q.front; // liên kết vòng
        } else {
            q.rear.link = temp;
            q.rear = temp;
            q.rear.link = q.front; // giữ liên kết vòng
        }

    }

    // Xoá phần tử đầu queue
    public void deQueue() {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        // Nếu chỉ có 1 phần tử
        if (q.front == q.rear) {
            q.front = q.rear = null;
        } else {
            q.front = q.front.link;
            q.rear.link = q.front;
        }
    }

    // Hiển thị queue
    public void displayQueue() {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = q.front;
        System.out.println("Queue: ");
        do {
            System.out.println(temp.data + " ");
            temp = temp.link;
        } while (temp != q.front);
        System.out.println();
    }
}
