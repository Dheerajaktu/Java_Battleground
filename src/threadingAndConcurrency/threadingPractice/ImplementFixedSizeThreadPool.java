package threadingAndConcurrency.threadingPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Process many incoming banking tasks using a limited number of worker threads rather than creating a thread for every request.
Concepts: ExecutorService, ThreadPoolExecutor, bounded queues, rejection policies.
*/

public class ImplementFixedSizeThreadPool {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskID = i;
            es.submit(() -> {
                System.out.println("Task is running..." + Thread.currentThread().getName() + "Task ID" + taskID);
            });
        }
        es.shutdown();
    }

}
