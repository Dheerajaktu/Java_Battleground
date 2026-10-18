package threadingAndConcurrency.threadingPractice;

public class ThreadSafeCounterReadAndWrite {
    public static void main(String[] args) {

        SharedCounter sc = new SharedCounter();

        Thread t1 = new Thread(() -> sc.increment(), "Write-T1");
        Thread t2 = new Thread(() -> sc.increment(), "Write-T2");
        Thread t3 = new Thread(
                () -> {
                    System.out.println("Read Count:: "+ sc.getCount());
                }, "Read-T3");
        Thread t4 = new Thread(() -> sc.increment(), "Write-T4");
        Thread t5 = new Thread(() -> sc.increment(), "Write-T5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class SharedCounter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println( Thread.currentThread().getName() + " Updated:: " + counter);
    }

    public synchronized int getCount() {
        return counter;
    }

}