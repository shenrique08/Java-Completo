package application;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count;
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final Lock lock = new ReentrantLock(true);

    void increment() {
        lock.lock();
        try {
            count++;
            atomicInteger.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}

public class App {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());

    }
}
