// File: AddAPennyTask.java

public class AddAPennyTask implements Runnable {
    private Account account;  // Tham chiếu đến Account muốn thao tác

    // Constructor yêu cầu phải truyền vào một Account
    public AddAPennyTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        // Mỗi thread sẽ gọi deposit(1) 1000 lần
        for (int i = 0; i < 1000; i++) {
            account.deposit(1);

            // Giả lập thời gian xử lý, để dễ quan sát race condition
            try {
                Thread.sleep(1); // ngủ 1ms giữa mỗi lần deposit
            } catch (InterruptedException e) {
                // Nếu có interrupt, dừng luôn
                return;
            }
        }
    }
}
