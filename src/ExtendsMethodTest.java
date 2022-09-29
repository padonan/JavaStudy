
class ExtendsMethodTestParent {
    int a;

    String testMethod() {
        System.out.println("123");
        return "123";
    }
}


public class ExtendsMethodTest extends ExtendsMethodTestParent {
}

class adfasf {
    public static void main(String[] args) {
        ExtendsMethodTest extendsMethodTest = new ExtendsMethodTest();
        extendsMethodTest.testMethod();
    }
}
