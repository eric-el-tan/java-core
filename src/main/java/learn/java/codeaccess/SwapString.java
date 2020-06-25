package learn.java.codeaccess;

import java.util.HashMap;
import java.util.Map;

public class SwapString {

    public static boolean addMap(Map<Integer,Integer> map, Integer a, Integer b){
        if (map.containsKey(a)){
            return false;
        }
        map.put(a,b);
        return true;
    }


    public static boolean balance(Map<Integer,Integer> m, final int a, final int b){
        if (!addMap(m, a, b))
            return false;

        if (a > b){
            return balance(m, b, a);
        }
        // case: a < b
        int i = a * 2;
        int j = (a+b)-i;

        if (i == j)
            return true;
        else
            return balance(m, i,j);
    }
}
