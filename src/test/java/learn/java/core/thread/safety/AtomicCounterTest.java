package learn.java.core.thread.safety;

import org.junit.jupiter.api.Test;

public class AtomicCounterTest {

    final static int TOTAL = 100000000;
    @Test
    public void OneThread() {
        long startTime = System.currentTimeMillis();

        final AtomicCounter counter = new AtomicCounter();
        for (int i = 0; i < TOTAL; i++) {
            counter.increment();
        }

        System.out.println(counter.count);
        System.out.println(String.format("took %d milliseconds", System.currentTimeMillis()-startTime));
    }

    @Test
    public void TwoThread(){
        long startTime = System.currentTimeMillis();

        final AtomicCounter counter = new AtomicCounter();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.count);
        System.out.println(String.format("took %d milliseconds", System.currentTimeMillis()-startTime));
    }
}
