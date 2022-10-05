import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
            System.out.println(num);
        }

        List<Integer> list = new LinkedList<>(set);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
