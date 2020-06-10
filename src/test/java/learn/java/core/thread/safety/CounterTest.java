package learn.java.core.thread.safety;

import org.junit.jupiter.api.Test;

/**
 * 13.7 Multithreading Synchronized Keyword https://www.youtube.com/watch?v=RH7G-N2pa8M
 */

public class CounterTest {

//    final static int TOTAL = 100000000;
    final static int TOTAL = 10;

    @Test
    public void OneThread() {
        long startTime = System.currentTimeMillis();

        final Counter counter = new Counter();
        for (int i = 0; i < TOTAL; i++) {
            counter.increment_synchronized_method();
        }

        System.out.println(counter.count);
        System.out.println(String.format("took %d milliseconds", System.currentTimeMillis()-startTime));
    }

    @Test
    public void TwoThread_synchonrized_method(){
        long startTime = System.currentTimeMillis();

        final Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment_synchronized_method();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment_synchronized_method();
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

    @Test
    public void TwoThread_synchronize_block(){
        long startTime = System.currentTimeMillis();

        final Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment_synchronize_block();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    counter.increment_synchronize_block();
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
