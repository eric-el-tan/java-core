package learn.java.core.thread.safety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    AtomicInteger count = new AtomicInteger();

    public void increment(){
        count.incrementAndGet(); // 3 operation; fetch 100, +1 , save 101 back
    }
}