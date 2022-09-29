import java.util.Optional;

class OptionalTestClass {

    String name = "ms";
}

public class OptionalTest {

    public static void main(String[] args) {
        OptionalTestClass optionalTestClass = new OptionalTestClass();
        Optional<String> optional = Optional.empty();
        Optional<String> optionalS = Optional.of("1");
        Optional<String> optionalS1 = Optional.ofNullable("123");

        String name = optionalS1.orElse("anonymous");
        System.out.println(name);
        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optionalS);
        System.out.println(optionalS1);
    }
}
