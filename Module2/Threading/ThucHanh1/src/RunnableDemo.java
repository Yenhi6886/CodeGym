public class RunnableDemo implements Runnable {
    private Thread thread;
    private final String threadName;

    public RunnableDemo(String name) {
        threadName = name;
        System.out.println(threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread "+threadName+" interrupted");
        }
        System.out.println("Thread "+threadName+" exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
