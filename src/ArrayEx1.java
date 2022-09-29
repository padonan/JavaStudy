public class ArrayEx1 {
    public static void main(String[] args) {
        int[] score = new int[5];

        for(int i=0; i < score.length; i++) {
            score[i] = i * 10;
            System.out.println(score[i]);
        }
    }
}
