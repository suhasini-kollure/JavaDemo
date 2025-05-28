package multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo example = new ReentrantLockDemo();
        example.outerMethod();
    }
}

//A Reentrant Lock in Java is a type of lock that allows a thread to acquire the same lock multiple times without causing a deadlock.
// If a thread already holds the lock, it can re-enter the lock without being blocked.
// This is useful when a thread needs to repeatedly enter synchronized blocks or methods within the same execution flow.
// The ReentrantLock class from the java.util.concurrent.
// locks package provides this functionality, offering more flexibility than the synchronized keyword,
// including try-locking, timed locking, and multiple condition variables for advanced thread coordination.
//Methods of ReentrantLock : lock(), tryLock(), tryLock(long timeout, TimeUnit unit), unlock(),lockInterruptibly()
