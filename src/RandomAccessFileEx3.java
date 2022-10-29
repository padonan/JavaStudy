import java.io.*;

public class RandomAccessFileEx3 {
    public static void main(String[] args) {
        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("src/sample.txt", "r");
            int i=4;

            while(true) {
                raf.seek(i);
                sum += raf.readInt();
                i += 16;
            }
        } catch (EOFException eofE) {
            System.out.println("sum :" + sum);
        } catch (IOException iE) {
            iE.printStackTrace();
        }
    }
}
