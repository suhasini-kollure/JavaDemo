package multithreading;

class SharedResource {
    private int data;
    private boolean hasData;

    // Produce method
    public synchronized void produce(int value) {
        while (hasData) {              // Wait until data is consumed
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();                   // Notify the consumer thread
    }

    // Consume method
    public synchronized int consume() {
        while (!hasData){           // Wait until data is produced
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();                   // Notify the producer thread
        return data;
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.produce(i);
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}


//wait() : Causes the current thread to release the monitor lock and wait until another thread invokes notify() or notifyAll().
//Must be called inside a synchronized block or method.
//notify() : Wakes up one waiting thread (if any) on the same monitor.
//notifyAll() : Wakes up all threads waiting on the same monitor.
