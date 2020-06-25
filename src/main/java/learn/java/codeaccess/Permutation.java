package learn.java.codeaccess;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Permutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

//        List<Integer> array1 = Arrays.asList(str1.split(" ", 0)).stream().map(Integer::parseInt).collect(Collectors.toList());
//        List<Integer> array2 = Arrays.asList(str2.split(" ", 0)).stream().map(Integer::parseInt).collect(Collectors.toList());

        Map<String, Integer> map1 = generateMap(str1);
        Map<String, Integer> map2 = generateMap(str2);
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
        System.out.println(map1.equals(map2));
    }

    public static Map<String, Integer> generateMap(String str1) {
        String[] strArray = str1.split(" ", 0);
        Map<String, Integer> map = new HashMap<>();
        for (String str:strArray) {
            if (map.containsKey(str)) {
                Integer i = map.get(str);
                map.put(str, i.intValue()+1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }
}
