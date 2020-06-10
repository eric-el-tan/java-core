package learn.java.core.thread.safety;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Jun 8 2020
 * why StringBuffer and StringBuilder are not thread-safe when append()
 */
public class StringBufferTest {

    final static int TOTAL = 100000;
    final NumberFormat numberFormat = new DecimalFormat("###,###,###");

    @Test
    public void OneThread(){
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < TOTAL; i++) {
            sb.append("a");
        }
        System.out.println(numberFormat.format(sb.length()));
        System.out.println(String.format("took %d milliseconds", System.currentTimeMillis()-startTime));
    }

    @Test
    public void TwoThread(){
        long startTime = System.currentTimeMillis();

        final StringBuilder sb = new StringBuilder();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    sb.append("a");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < TOTAL/2; i++) {
                    sb.append("a");
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

        System.out.println(numberFormat.format(sb.length()));
        System.out.println(String.format("took %d milliseconds", System.currentTimeMillis()-startTime));
    }
}
