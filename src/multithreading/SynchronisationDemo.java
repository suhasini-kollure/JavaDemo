package multithreading;

//Using Count class
public class SynchronisationDemo extends Thread {
    private Counter counter;

    public SynchronisationDemo(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        SynchronisationDemo s1 = new SynchronisationDemo(counter);
        SynchronisationDemo s2 = new SynchronisationDemo(counter);
        s1.start();
        s2.start();
        try {
            s1.join();
            s2.join();
        } catch (Exception e) {

        }

        System.out.println(counter.getCount()); // Expected: 2000, Actual will be random <= 2000 before synchronizing the increment method

    }
}

/*
The output of the code is not 2000 because the increment method in the Counter class is not synchronized.
This results in a race condition when both threads try to increment the count variable concurrently.
Without synchronization, one thread might read the value of count before the other thread has finished writing its incremented value.
This can lead to both threads reading the same value, incrementing it, and writing it back, effectively losing one of the increments.
We can fix this by using synchronized keyword. By synchronizing the increment method in Counter class*/
