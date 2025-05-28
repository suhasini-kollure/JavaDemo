package multithreading;

//yield(): Thread.yield() is a static method that suggests the current thread temporarily pause its execution
// to allow other threads of the same or higher priority to execute.
// It’s important to note that yield() is just a hint to the thread scheduler,
// and the actual behavior may vary depending on the JVM and OS.
public class YieldDemo extends Thread {

    public YieldDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");

            //After every iteration telling scheduler to give chance to other threads to run by calling below method
            Thread.yield();
        }
    }

    public static void main(String[] args) {

        YieldDemo t1 = new YieldDemo("t1");
        YieldDemo t2 = new YieldDemo("t2");
        t1.start();
        t2.start();

    }
}
