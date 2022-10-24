public class WhileEx {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;

        while(true) {
            for(int i : testArray) {
                System.out.println("i="+i);
                sum += i;
                System.out.println("sum="+sum);
            }
            break;
        }
    }
}
