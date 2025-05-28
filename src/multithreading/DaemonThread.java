package multithreading;

//A daemon thread in Java is a background thread that runs in parallel with other threads in a program.
//They are used to perform low-priority tasks like garbage collection, monitoring, and other system-level operations.
//They are terminated when all user threads finish
//When to use daemon threads?
//Daemon threads can be used for background tasks like logging, monitoring, or network communication.
//They can also be used for garbage collection and finalizers.

public class DaemonThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello");
        }
    }
    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        t1.setDaemon(true); // myThread is daemon thread ( like Garbage collector ) now
        MyThread t2 = new MyThread();
        t2.start(); // t1 is user thread
        t1.start();
        System.out.println("Main Done");

    }
}
