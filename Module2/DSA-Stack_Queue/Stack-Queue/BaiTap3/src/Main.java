public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.enQueue(10);
        s.enQueue(20);
        s.enQueue(40);
        s.displayQueue();
        
        s.deQueue();
        s.displayQueue();

        s.deQueue();
        s.deQueue();
        s.displayQueue();
    }
}
