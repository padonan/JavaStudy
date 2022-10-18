import java.util.ArrayList;
import java.util.HashMap;


public class ToStringTest {

    public String toString() {
        return "name=" + name + "인스턴스";
    }

    String name = "123";

    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = "12345";
        ToStringTest toStringTest = new ToStringTest();
        ToStringTest toStringTest2 = new ToStringTest();
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Integer> integerList = new ArrayList<Integer>();

        System.out.println(toStringTest);

        map.put("123","123");
        System.out.println(map.get("123"));

        stringList.add("123");
        integerList.add(123);
        System.out.println(stringList.get(0));

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(toStringTest==toStringTest2);
        System.out.println(toStringTest.equals(toStringTest2));
        System.out.println(toStringTest);

        if(toStringTest instanceof ToStringTest)
            System.out.println("toStringTest는 ToStringTest의 인스턴스 입니다.");
    }
}
