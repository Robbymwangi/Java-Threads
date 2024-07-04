public class BankSimulation {
    public static void main(String[] args) {
        // Step 1: Create a BankAccount instance with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Step 2: Create DepositThread and WithdrawThread instances
        DepositThread deposit1 = new DepositThread(account, 500);
        DepositThread deposit2 = new DepositThread(account, 200);
        WithdrawThread withdraw1 = new WithdrawThread(account, 400);
        WithdrawThread withdraw2 = new WithdrawThread(account, 300);

        // Step 3: Start the threads
        deposit1.start();
        deposit2.start();
        new Thread(withdraw1).start(); // WithdrawThread implements Runnable, so it needs to be passed to a Thread constructor
        new Thread(withdraw2).start();

        // Note: In a real application, you'd want to join the threads before checking the balance
        // to ensure all transactions have been processed.
        System.out.println("Final account balance: " + account.getBalance());
    }
}