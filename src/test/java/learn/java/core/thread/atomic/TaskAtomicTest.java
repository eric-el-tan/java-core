package learn.java.core.thread.atomic;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskAtomicTest {

    @Test
    public void examinePerformanceOfLock(){
        TaskLock taskLock = new TaskLock();

        int numberOfThreads = 50;
        Thread[] threads = new Thread[numberOfThreads];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(taskLock);
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Lock results: %d\n", System.currentTimeMillis()-startTime);
    }

    @Test
    public void examinePerformanceOfAtomic(){
        TaskAtomic taskAtomic = new TaskAtomic();

        int numberOfThreads = 50;
        Thread[] threads = new Thread[numberOfThreads];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(taskAtomic);
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Atomic results: %d\n", System.currentTimeMillis()-startTime);
    }
}
