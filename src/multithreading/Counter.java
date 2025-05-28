package multithreading;

public class Counter {

    private int count = 0;      // shared resource

//    public void increment() {
//        count++;
//    }

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

//By synchronizing the increment method, we ensure that only one thread can execute this method at a time,
// which prevents the race condition.
// With this change, the output will consistently be 2000.