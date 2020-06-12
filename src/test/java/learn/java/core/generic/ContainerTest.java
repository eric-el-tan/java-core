package learn.java.core.generic;

import org.junit.jupiter.api.Test;

public class ContainerTest {

    @Test
    public void containerOfInteger(){
        Container<Integer> container = new Container<>();
        container.value = 9;
        container.show();
    }

    @Test
    public void containerOfDouble(){
        Container<Double> container = new Container<>();
        container.value = 9.9;
        container.show();
    }

    @Test
    public void containerOfString(){
//        Container<String> container = new Container<>();  // compiler error: not of class Number
//        container.value = "Eric";
//        container.show();
    }
}
