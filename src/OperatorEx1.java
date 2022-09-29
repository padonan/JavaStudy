public class OperatorEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        int x;

        System.out.println(str1.equals("abc") == (str2.equals("abc")));
        System.out.println(str1==str2);
        System.out.println(str1.equals("abc") ^ (str2.equals("abc")));
        System.out.println(x = 3);
    }
}
