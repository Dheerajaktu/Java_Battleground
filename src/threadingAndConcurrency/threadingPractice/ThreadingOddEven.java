package threadingAndConcurrency.threadingPractice;

public class ThreadingOddEven {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 7, 87, 64, 2, 4, 67, 7, 3, 2, 2, 5, 6, 7, 7 };

        Thread t1 = new Thread(() -> {
            for (int val : arr) {
                if (val % 2 == 0) {
                    System.out.println(":: Even Numbers::" + val + ":: Thread Name" + Thread.currentThread().getName());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int val : arr) {
                if (val % 2 != 0) {
                    System.out.println(":: Odd Numbers::" + val + ":: Thread Name" + Thread.currentThread().getName());
                }
            }
        });

        t1.start();
        t2.start();
    }
}


/*
NOTE :: In avobe program basically two thread are printing odd/Even values, but both thread are traversing entire list.
        so we can solve this issue, using queue.
*/