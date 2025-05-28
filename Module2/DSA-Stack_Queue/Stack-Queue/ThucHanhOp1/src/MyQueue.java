public class MyQueue {
    private int capacity; // Sức chứa tối đa của hàng đợi
    private int[] queueArr; // Mảng chứa dữ liệu
    private int head; // Vị trí (chỉ số) của phần tử đầu tiên lấy phần tử ra (deQueue)
    private int tail; // '' cuối
    private int currentSize; //Số phần tử hiện tại trong hàng đợi

    public MyQueue(int queueSize) { //Nhận vào queueSize xác định độ dài queue.
        this.capacity = queueSize; // Gán vào capacity.
        queueArr = new int[queueSize];
    }

    // Kiểm tra hàng đợi đã đầy chưa
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    // Kiểm tra hàng đợi có rỗng không
    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    // Thêm phần tử
    public void enQueue(int value) {
        if (isQueueFull()) {
            System.out.println("Queue is full "+value);
        } else {
            tail = (tail + 1) % capacity; //% capacity quay vòng về 0 nếu tail tới cuối mảng, tail start-1.
            queueArr[tail] = value;
            currentSize++;
            System.out.println("Enqueue " + value + " is pushed to the queue");
        }
    }

    //Xoá phần tử
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++;
            if (head == capacity - 1) { //Nếu head tới cuối mảng → đặt lại head = 0 để nối vòng.
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                //queueArr[head - 1] → Dòng này in ra phần tử vừa xoá, là phần tử trước head.
            }
            currentSize--;
        }
    }
}
