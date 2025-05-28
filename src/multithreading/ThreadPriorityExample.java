package multithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.println("Thread 1 is running..."));
        Thread t2 = new Thread(() -> System.out.println("Thread 2 is running..."));
        Thread t3 = new Thread(() -> System.out.println("Thread 3 is running..."));

        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY); // Priority 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();


    }
}
