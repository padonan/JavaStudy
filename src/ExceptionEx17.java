public class ExceptionEx17 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main메서드에서 예외가 처리되었습니다.");
        }
    }

    static void method1() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1메서드에서 예외가 처리되었습니다.");
            throw e;
        }
    }

    static int method2() throws Exception {
        try {
            System.out.println("method2 호출");
            return 1;
        } catch(Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            System.out.println("method1의 finally 호출");
        }
    }
}
