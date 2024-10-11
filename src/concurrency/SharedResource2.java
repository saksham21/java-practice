package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource2 {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }
    public int get() {
        return counter.get();
    }
}
