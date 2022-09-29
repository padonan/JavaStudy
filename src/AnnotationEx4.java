import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.annotation.ElementType.*;

class MyArrayList<T> {
    T[] arr;

    @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SuppressWarnings {
        String[] value();
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    MyArrayList(T... arr) {
        this.arr = arr;
    }

//    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> MyArrayList<T> asList(T... a) {
        return new MyArrayList<>(a);
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}

public class AnnotationEx4 {


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
      MyArrayList<String> list = MyArrayList.asList("1", "2", "3");
      System.out.println(list);
      double b = 3;
      double a = (int) b;
        System.out.println(a);

    }
}
