package learn.java.core.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    public void question1(){
        int x = 100;
        double y = 100.1;
        boolean b = (x == y);
        System.out.println(b);
    }

    @Test
    public void question3(){
        int[] array = {1,2,3,4,5};

        for (int j=1; j<5; j++) {
            for (int i : array) {
                if (i < 2) {
                    continue;
                }
                System.out.println("i = " + i);
                if (i == 3) {
                    break;
                }
            }
//            System.out.println("j = "+ j);

        }
    }

    @Test
    public void question4_int(){
        int i = 0;
        switch (i){
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            default:
                System.out.println("default");
                break;
        }
    }

    @Test
    public void question4a_Integer(){
        Integer i = 0;
        switch (i){
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            default:
                System.out.println("default");
                break;
        }
    }

    @Test
    public void question4b_String(){
        String s = "S";
        switch (s){
            case "S":
                System.out.println("S");
            case "Tom":
                System.out.println("Tom");
            default:
                System.out.println("default");
                break;
        }
    }

    @Test
    public void question5(){
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean bool = (a=true) || (b=true) && (c=true);    // <-- || then &&
        System.out.println("bool = " + bool);
        System.out.println(String.format("a=%s,b=%s,c=%s",a,b,c));
    }

    @Test
    public void question5_b(){
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean bool = (a=true) && (b=true) || (c=true);    // <-- && then ||
        System.out.println("bool = " + bool);
        System.out.println(String.format("a=%s,b=%s,c=%s",a,b,c));
    }

    @Test
    public void question7(){
        String h1 = "Bob";
        String h2 = new String("Bob");
//        String h2 = "Bob";
        System.out.println(h1.hashCode());
        if (h1 == h2){
            System.out.println("same reference");
        }
        if (h1.equals(h2)) {
            System.out.println("same value");
        }
    }

    @Test
    public void question7_b(){
        Integer h1 = 1;
        Integer h2 = 2;
        if (h1 == h2){
            System.out.println("same reference");
        }
        if (h1.equals(h2)) {
            System.out.println("same value");
        }
    }

    @Test
    public void question14(){
        int m = increment(0);
        m += 3 + ++m;
        System.out.println(m);
    }

    public static int increment(int i){
        return ++i;
    }
}
