package threadingAndConcurrency.threadingPractice;


public class CreateThread {

    public static void main(String[] args) {

        Thread1 t1 = new Thread1();
        t1.start();

        Thread t2 = new Thread(new Thread2());
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println(">>Thread3 is running:: ");
        });
        t3.start();

        Runnable t4a = new Thread(() -> {
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                 System.out.println("EX:: "+ e);
            }
            
            System.out.println(">>Thread4 is running:: ");
        });

        Thread t4 = new Thread(t4a);
        t4.start();

    }

}

class Thread1 extends Thread {
    public void run() {
        System.out.println(">>Thread1 is running:: ");
    }
}

class Thread2 implements Runnable {
    public void run() {
        System.out.println(">>Thread2 is running:: ");
    }
}
