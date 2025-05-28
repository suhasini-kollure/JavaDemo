package multithreading;

public class ThreadDemo extends Thread {

    @Override
    public void run() {

        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo t1 = new ThreadDemo();
        t1.start();
        t1.join();
        System.out.println("Hello");
    }
}
