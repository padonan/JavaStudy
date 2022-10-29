import java.util.ArrayList;

class FruitEx implements Eatable {

}

class Apple extends FruitEx {
    public String toString() {
        return "Apple";
    }
}

class Grape extends FruitEx {
    public String toString() {
        return "Grape";
    }
}

class Toy  {
    public String toString() {
        return "Toy";
    }
}

interface Eatable {}

public class GenericEx1 {
    public static void main(String[] args) {
        FruitBoxEx<FruitEx> fruitBoxEx = new FruitBoxEx<>();
        FruitBoxEx<Apple> appleBoxEx = new FruitBoxEx<Apple>();
        FruitBoxEx<Grape> grapeBoxEx = new FruitBoxEx<Grape>();
       // FruitBoxEx<Grape> grapeBoxEx2 = new FruitBoxEx<Apple>();
        // FruitBoxEx<Toy> toyBox = new FruitBoxEx<Toy>();

        fruitBoxEx.add(new FruitEx());
        fruitBoxEx.add(new Apple());
        fruitBoxEx.add(new Grape());
        appleBoxEx.add(new Apple());
        // appleBoxEx.add(new FruitEx());
        grapeBoxEx.add(new Grape());

        System.out.println("fruitBoxEx-"+fruitBoxEx);
        System.out.println("appleBoxEx-"+appleBoxEx);
        System.out.println("grapeBoxEx-"+grapeBoxEx);
    }
}

class FruitBoxEx <T extends FruitEx & Eatable> extends BoxEx<T> {}

class BoxEx<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}