import java.io.*;

public class DataOutputStreamEx3 {
    public static void main(String[] args) {
        int[] score = { 100, 90, 95, 85, 50 };

        try {
            FileOutputStream fos = new FileOutputStream("src/score.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for (int j : score) {
                dos.writeInt(j);
            }

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
