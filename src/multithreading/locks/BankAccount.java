package multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}


//The synchronized keyword in Java provides basic thread-safety but has limitations:
// it locks the entire method or block, leading to potential performance issues.
// It lacks a try-lock mechanism, causing threads to block indefinitely, increasing the risk of deadlocks.
// Additionally, synchronized doesn't support multiple condition variables,
// offering only a single monitor per object with basic wait/notify mechanisms.
// In contrast, explicit locks (Lock interface) offer finer-grained control, try-lock capabilities to avoid blocking,
// and more sophisticated thread coordination through multiple condition variables, making them more flexible and
// powerful for complex concurrency scenarios