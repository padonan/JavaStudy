public class StringBufferMethods {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("0123456");
        sb.setLength(5);

        StringBuffer sb2 = new StringBuffer("0123456가");
        sb2.setLength(10);

        System.out.println(sb2);

        String str = sb2.toString().trim();

        System.out.println(sb2);
        
    }
}
