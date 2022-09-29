import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;



public class MetaAnnotationEx {
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
@interface SuppressWarnings {
    String[] value();
}

@Target({FIELD, TYPE, TYPE_USE})
@interface MyAnnotation {  }

@MyAnnotation
class MyClass {
    @MyAnnotation
    int i;

    @MyAnnotation
    MyClass mc;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface Override {}
