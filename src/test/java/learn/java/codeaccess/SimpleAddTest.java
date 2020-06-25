package learn.java.codeaccess;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimpleAddTest {
    @Test
    public void using_Scanner() {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(scanner.next());
            b = Integer.parseInt(scanner.next());
        } catch (NoSuchElementException e){

        }
        System.out.println(a+b);
    }

    @Test
    public void using_scanner_whileloop() {
        Scanner scanner = new Scanner(System.in);
        String str;
        int a = 0;
        str = scanner.next();
        while (str != null
                && !str.equalsIgnoreCase("")
        ){
            a += Integer.parseInt(str);
            str = scanner.next();
        }
        System.out.println(a);
    }

    @Test
    public void using_datainputstream_whileloop() throws Exception {
        //use the following code to fetch input from console
        String line;
        DataInputStream in = new DataInputStream(System.in);

        int a = 0;
        while ((line = in.readLine()) != null && !line.equalsIgnoreCase("") && a == 0)
        {
            a += Integer.parseInt(line);
        }
        if (a != 0)
            System.out.println(a);
    }

    @Test
    public void using_datainputstream_if() throws Exception {
        String line;
        DataInputStream in = new DataInputStream(System.in);

        int a = 0;
        line = in.readLine();
        if (line != null && !line.equalsIgnoreCase("")) {
            a = Integer.parseInt(line);
        }

        int b = 0;
        line = in.readLine();
        if (line != null && !line.equalsIgnoreCase("")) {
            b = Integer.parseInt(line);
        }
        System.out.println(a+b);
    }
}