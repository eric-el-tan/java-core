package learn.java.core.thread.multithread;

//13.3 Multithreading using Runnable Interface https://www.youtube.com/watch?v=xvXbvrUUGMM

class Hii implements Runnable {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hii - " + i );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Helloo implements Runnable {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Helloo - " + i );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Runnable hii = new Hii();
        Runnable helloo = new Helloo();

        Thread thread1 = new Thread(hii);
        Thread thread2 = new Thread(helloo);

        thread1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
