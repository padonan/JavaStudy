package house;


interface MyFunction {
    public abstract int max(int a, int b);
    MyFunction f = (a, b) -> a > b ? a : b;

    int big = f.max(5, 3);
}


public class Lambda {
    public static void main(String[] args) {
        System.out.println(MyFunction.big);
    }
}

class Parent {
    int a;
}
class Child extends Parent {
    int b;
    Child(int a, int b) {
        super.a = a;
        this.b = b;
    }
}

class Test {
    public static void main(String[] args) {
    }
}
