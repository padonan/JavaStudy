import java.util.ArrayList;

class Fruit {

}

class FruitBox<T extends Fruit> extends Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }
}

class Box<T> {

}