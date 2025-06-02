public class NumberGenerator implements Runnable {

    @Override
    public void run() {
        int generatorHash = this.hashCode();
        for (int i = 0; i < 10; i++) {
            System.out.println("Generator " + generatorHash + " in ra: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.printf("Generator [%d] bị ngắt!%n", generatorHash);
                return;
            }
        }
        System.out.printf("Generator [%d] đã hoàn thành.%n", generatorHash);
    }
}
