package learn.java.codeaccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicRotationTest {
    
    @Test
    public void twoCase() {
        System.out.println(caller("ababab"));
    }

    @Test
    public void zeroCase() {
        System.out.println(caller("aaaaba"));
    }

    @Test
    public void NCase() {
        System.out.println(caller("abcabc"));
    }

    private int caller(String str) {
        return CyclicRotation.cyclic(str, 1);
    }

//    private int caller(String str) {
//        int noOfFound = 0;
//        for (int i = 1; i < str.length() - 1; i++) {
//            noOfFound += CyclicRotation.cyclic(str, i);
//        }
//        return noOfFound;
//    }
}
