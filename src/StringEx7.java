public class StringEx7 {
    public static void main(String[] args) {
        String fullname = "Hello. java";

        int index = fullname.indexOf('.');
        String filename = fullname.substring(0, index);
        String ext = fullname.substring(index+1);

        System.out.println(fullname + "의 확장자를 제외한 이름은 " + filename);
        System.out.println(fullname + "의 확장자는 " + ext);
    }
}
