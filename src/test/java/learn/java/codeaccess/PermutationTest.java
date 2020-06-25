package learn.java.codeaccess;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PermutationTest {
    @Test
    public void testPermutation_pass() {
        Map<String, Integer> map1 = Permutation.generateMap("1 2 5 3 7 0 7 3 5 2 1");
        Map<String, Integer> map2 = Permutation.generateMap("7 3 1 2 5 0 5 2 1 3 7");
        assertTrue(map1.equals(map2));
    }
    
    @Test
    public void testPernutation_fail() {
        Map<String, Integer> map1 = Permutation.generateMap("1 2 3 4 5 6 7 8 9 10 11");
        Map<String, Integer> map2 = Permutation.generateMap("6 5 4 3 2 0 11 10 9 8 7");
        assertFalse(map1.equals(map2));
    }
}