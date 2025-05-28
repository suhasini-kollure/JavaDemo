package multithreading;

//interrupt(): Interrupts the thread.
// If the thread is blocked in a call to wait(), sleep(), or join(), it will throw an InterruptedException.

public class InterruptedExceptionDemo extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(100);
            System.out.println("Thread is running....");
        } catch (InterruptedException e) {
            System.out.println("Interrupted thread -> " + e);
        }
    }

    public static void main(String[] args) {
        InterruptedExceptionDemo d = new InterruptedExceptionDemo();
        d.start();

        //main method is interrupting what ever task (d) is running
        //when the sleep is interrupted then exception will be thrown
        d.interrupt();

    }
}
