public class CastingEx1 {
    public static void main(String[] args) {
        double d = 85.4;
        int score = (int)d;

        System.out.println("score="+score);
        System.out.println("d="+d);

        int d1 = 85;
        double score1 = d1;
        System.out.println("score1="+score1);
    }
}
