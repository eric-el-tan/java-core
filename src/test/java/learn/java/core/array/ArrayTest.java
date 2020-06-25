package learn.java.core.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {
    @Test
    public void question16() {
        int[] source = {1,2,3,4,5};
        int[] target = new int[5];
        for (int i : source) {
            System.out.print(i);
        }

        System.out.println("");
        System.arraycopy(source, 2, target, 1, 2);
        for (int i : target) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println("array[1] = " + source[1]);
        System.out.println("array[4] = " + source[4]);
    }

    @Test
    public void question15() {
        int index = 1;
        try{
            getArray()[index=2]++;
        } catch (Exception e){}
        System.out.println("index = " + index);
    }

    private long[] getArray() {
        return null;
    }
    
    @Test
    public void question14() {
        int[][] a = new int[2][4];
        int[][] b = new int[2][];
//        int[][] c = new int[2];
        a[0] = new int[3];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;

        a[1] = new int[4];
        a[1][0] = 10;
        a[1][1] = 20;
        a[1][2] = 30;
        a[1][3] = 40;
    }

    @Test
    public void question13() {
        char[] c = new char[2];
        int length = c.length;
    }

    @Test
    public void question12() {
        String[] args = {"a", "b", "c"};
        System.out.println("args = " + args);       // args = [Ljava.lang.String;@3dfc5fb8
        System.out.println("args.length = " + args.length);

        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");
        System.out.println("list = " + list);       // list = [a, b, c]
        System.out.println("list.size() = " + list.size());
    }

    @Test
    public void question11() {
        int[] val = {6,-4,12,0,-10};
        assertEquals(2, Arrays.binarySearch(val, 12));
        assertEquals(2, Arrays.binarySearch(val, 1, 3, 0));
    }

}
