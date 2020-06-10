package learn.java.core.thread.multithread;

//13.2 Multithreading in Java Practical https://www.youtube.com/watch?v=Xj1uYKa8rIw

class Hi extends Thread {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi - " + i );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Hello extends Thread {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello - " + i );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Hi hi = new Hi();
        Hello hello = new Hello();

        hi.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hello.start();
    }
}
