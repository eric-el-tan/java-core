package learn.java.core.time;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;

public class TimeTest {

    @Test
    public void localTime(){
        LocalTime time1 = LocalTime.now();
        System.out.println(time1);

//        LocalTime time2 = LocalTime.now(ZoneId.of(default));
//        System.out.println(time2);
    }
}
