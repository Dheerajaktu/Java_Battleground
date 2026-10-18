package threadingAndConcurrency.threadingPractice;

import java.util.Arrays;

/*
Multiple threads increment a shared transaction counter. Ensure the final count is correct.
Concepts: synchronized, AtomicInteger, LongAdder.
*/
public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCount counter = new ThreadSafeCount();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            String threadName = "T" + i;
            threads[i] = new Thread(
                    () -> counter.incrementCount(), threadName);
            threads[i].start();
        }
        System.out.println("Threads Array:: "+ Arrays.toString(threads));
        //Wait for all threds
        for(Thread t: threads){
            t.join();
        }
        System.out.println("Counter Value:: " + counter.getCount());
    }

}

class ThreadSafeCount {
    private int counter = 0;

    public synchronized void incrementCount() {
        counter += 1;
    }

    public int getCount() {
        return counter;
    }
}
