package learn.java.codeaccess;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {

    // i = increment
    public static int cyclic(final String str, final int i) {
        int len = str.length();
        if (len <= 0)
            return 0;

        char[] news = str.toCharArray();
        char[] ori = str.toCharArray();

        int s = 0;
        int m = 0;
        int n = i;
        int noOfFound = 0;
        while (n < len) {
            while (n < len) {
                if (ori[(m+s)%len] != news[(n+s)%len]) {
                    n+=i;
                } else {
                    s++;
                }
                if (s >= len){
                    noOfFound++;
                    s=0;
                    n+=i;
                    break;
                }
            }
//            if (n>=len){
//                break;
//            }
        }
        return noOfFound;

//        for (int m = 0; m < str.length()-1; m++) {
//            for (int n = 1; n < maxLen; n++) {
//                if (ori[m+s] != news[n+s])
//                    continue;
//                s++;
//                if (n+s >= maxLen) n = 0;
//            }
//        }
    }
}
