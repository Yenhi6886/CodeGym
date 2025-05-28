public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enQueue(4);
        queue.dequeue();
        queue.enQueue(33);
        queue.enQueue(43);
        queue.enQueue(86);
        queue.dequeue();
        queue.dequeue();
        queue.enQueue(96);
        queue.dequeue();
        queue.enQueue(97);
        queue.enQueue(22);
        queue.enQueue(11);
        queue.enQueue(115);
    }
}
