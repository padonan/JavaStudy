import java.io.*;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/data2.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 1);

            for(int i='1'; i<='9'; i++) {
                bos.write(i);
            }
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
