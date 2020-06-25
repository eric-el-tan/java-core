package learn.java.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    https://www.javaguides.net/2018/07/java-8-functional-interfaces.html
 */
public class LambdaTest {
    @Test
    public void predicate() {
        Predicate<Person> isAgeGt28 = (p) -> p.getAge() > 28;
        assertTrue(isAgeGt28.test(new Person("ramesh", 29)));
    }

    @Test
    public void function_centigradeToFahrenheit() {
        // convert centigrade to fahrenheit
        Function<Integer, Double> centigradeToFahrenheit = x -> new Double((x * 9 / 5) + 32);
        System.out.println("LambdaTest.function_centigradeToFahrenheitInt");
        System.out.println("centigradeToFahrenheitInt = " + centigradeToFahrenheit.apply(10));
    }

    @Test
    public void function_stringToInt() {
        Function<String,Integer> strToInt = x -> Integer.valueOf(x);
        assertEquals(4, strToInt.apply("4"));
    }

    @Test
    public void function_objectToObject() {
        Function<PersonEntity, PersonDto> function = (entity) -> {
            return new PersonDto(entity.getName(), entity.getAge());
        };
        PersonEntity personEntity = new PersonEntity("ramesh", 20);
        PersonDto personDto = function.apply(personEntity);

        assertEquals(personDto.getName(), personEntity.getName());
        assertEquals(personDto.getAge(), personEntity.getAge());
    }
    
    @Test
    public void supplier() {
        Supplier<Person> supplier = ()->new Person("Ramesh", 30);
        Person p = supplier.get();
        System.out.println("LambdaTest.supplier");
        System.out.println("p = " + p);
    }
}
