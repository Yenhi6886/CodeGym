public class Main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();

        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();

        System.out.printf("Thread %s có priority: %d%n",
                thread1.getName(), thread1.getPriority());
        System.out.printf("Thread %s có priority: %d%n",
                thread2.getName(), thread2.getPriority());
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread bị ngắt khi chờ join!");
        }

        System.out.println("Main đã kết thúc, cả hai Generator đều xong việc.");
    }
}