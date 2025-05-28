package multithreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("RUNNING");  //4

        //making t1 execution pause
        try {                          //5
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();       //1
        System.out.println(t1.getName());
        System.out.println(t1.getState());

        t1.start();                         //2
        System.out.println(t1.getState());

        //making main method to sleep or pause for some time to execute run() method
        Thread.sleep(100);            //3

        System.out.println(t1.getState());  //6

        //main method is waiting for t1 to get finished
        t1.join();                          //7
        System.out.println(t1.getState());

    }
}
