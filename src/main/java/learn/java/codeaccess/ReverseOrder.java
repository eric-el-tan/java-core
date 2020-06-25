package learn.java.codeaccess;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = scanner.nextLine();

//        reverseOrder1(str, str2);
        reverseOrder_int(str, str2);
    }

    public static void reverseOrder1(String str, String str2) {
        int i = Integer.parseInt(str);
        for (int j = str2.length(); j > 0; j--){
            System.out.print(str2.charAt(j - 1));
        }
    }

    public static void reverseOrder_int(String str, String str2) {
        int noOfInteger = Integer.parseInt(str);
        if (noOfInteger == 0)
            return;

        String[] strings = str2.split(" ", 0);
        List<Integer> integers = Arrays.asList(strings).stream().map(Integer::parseInt).collect(Collectors.toList());
        for (int i = noOfInteger-1; i>=0; i--) {
            if (i < noOfInteger-1)
                System.out.print(" ");
            System.out.print(integers.get(i));
        }
    }
}
