package threadingAndConcurrency.threadingPractice;

/*
Two threads withdraw money from the same account simultaneously. Prevent an incorrect balance and overdraft.
Concepts: synchronized, race condition, atomicity.

*/

public class ThreadSafeBankAccount {
    public static void main(String[] args)  throws InterruptedException{

        BankAccount account = new BankAccount();

        // Thread t1 = new Thread(() -> account.withdrawAmount(300), "Dheeraj");

        // Thread t2 = new Thread(() -> account.withdrawAmount(300), "Princy");

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        for(int i = 1; i<=100; i++){
            String name = "Dheeraj"+i;
            Thread t = new Thread(() -> account.withdrawAmount(1), name);
            t.start();
            System.out.println("Final balance:: " + account.getBalance());
        }

        // System.out.println("Final balance:: " + account.getBalance());clear
        
    }
}

class BankAccount {

    private int balance = 1000;

    public synchronized void withdrawAmount(int amount) {
        if (amount < 0)
            System.out.println("Unable to process Amount:: " + amount);

        if (amount >= balance) {
            System.out.println("Insufficient Amount:: " + amount);
        } else {
            System.out.println("Widhdrwaing Amount:: " + amount + "::Name -" + Thread.currentThread().getName());
            balance -= amount;
            System.out.println("Amount Wdithdrawn Successfully:: ");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}