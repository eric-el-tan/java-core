package learn.java.codeaccess;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SwapStringTest {
    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "defg";
//        char[] c1 = s1.toCharArray();
//        char[] c2 = s2.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        assertFalse(SwapString.balance(map, s1.length(), s2.length()));
    }

    @Test
    public void test2() {
        String s1 = "ee";
        String s2 = "aaaaaaaaaaaaaa";
        String[] s = s2.split(" ");
        Map<Integer,Integer> map = new HashMap<>();
        assertTrue(SwapString.balance(map, s1.length(), s2.length()));
    }

}