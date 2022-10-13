public class asdfTest {
    int remainCountTime = 60;

    void countDecrement() {
        for(int i=60; i > 0; i--) {
            System.out.println(i);
            remainCountTime--;
            System.out.println(remainCountTime);
        }
    }

    public static void main(String[] args) {
        asdfTest asdfTest = new asdfTest();
        asdfTest.countDecrement();
    }
}
