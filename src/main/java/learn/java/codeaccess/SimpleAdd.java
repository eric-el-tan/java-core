package learn.java.codeaccess;

import java.io.DataInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleAdd {
    public static void main(String[] args) throws Exception {
        String[] line = new String[4];

        DataInputStream in = new DataInputStream(System.in);

        int i = 0;
        while ((line[i++]=in.readLine())!=null){
        }
        System.out.println(line[0]);
        System.out.println(line[1]);

//        int m = in.readInt();
//        int n = in.readInt();
//        System.out.println(m+n);

    }
}

