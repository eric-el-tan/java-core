package learn.java.core.thread.multithread;

//13.4 MultiThreading using Lambda Expression https://www.youtube.com/watch?v=VDYSgjPxu18


/**
 * 1. reduce number of lines
 * 2. use anomous class
 */
public class LambdaDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi - " + i );
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello - " + i );
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
