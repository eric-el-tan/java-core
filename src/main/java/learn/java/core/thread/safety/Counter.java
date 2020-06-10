package learn.java.core.thread.safety;

//https://www.youtube.com/watch?v=px4W-HXRWKk

public class Counter{

    int count;

    public synchronized void increment_synchronized_method(){
        count++; // 3 operation;
        // 1. read count 100
        // 2. addition +1
        // 3. write 101
    }

    public void increment_synchronize_block(){
        System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            count++; // 3 operation;
            // 1. read count 100
            // 2. addition +1
            // 3. write 101
        }
    }

}