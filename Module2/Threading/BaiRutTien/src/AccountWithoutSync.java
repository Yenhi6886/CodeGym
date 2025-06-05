public class AccountWithoutSync {
    public static void main(String[] args) {
        Account account = new Account();

        AddAPennyTask addAPennyTask1 = new AddAPennyTask(account);
        AddAPennyTask addAPennyTask2 = new AddAPennyTask(account);

        Thread thread1 = new Thread(addAPennyTask1);
        Thread thread2 = new Thread(addAPennyTask2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Bi ngat khi cho join()");
        }

        System.out.println("So du cuoi cung " + account.getBalance());

    }
}
