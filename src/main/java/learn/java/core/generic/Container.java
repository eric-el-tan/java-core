package learn.java.core.generic;

/**
 * [Generics in Java](https://www.youtube.com/watch?v=XMvznsY02Mk)
 * @param <T> Type
 */
public class Container<T extends Number> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void show(){
        System.out.println(value.getClass().getName());
    }
}
