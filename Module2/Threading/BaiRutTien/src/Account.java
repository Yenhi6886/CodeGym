public class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        int newBalance = balance + amount;
        balance = newBalance;
    }
}