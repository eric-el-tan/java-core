package learn.java.core.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    @Test
    public void withoutTypeSafety(){
        List value = new ArrayList();
        value.add(5);
        value.add("Eric");
    }

    @Test
    public void withTypeSafety(){
        List<Integer> value = new ArrayList<>();
        value.add(5);
//        value.add("Eric");
    }
}

