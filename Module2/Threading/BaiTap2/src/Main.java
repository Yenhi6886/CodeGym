public class Main {
    public static void main(String[] args) {
//        OddThread oddThread = new OddThread();
//        oddThread.start();
//        EvenThread evenThread = new EvenThread();
//        evenThread.start();
        OddThread ood = new OddThread();
        EvenThread even = new EvenThread();
        ood.start();
        try {
            ood.join();
        } catch (InterruptedException e) {
            System.out.println("Luong bi gian doan ");
        }
        even.start();
    }
}