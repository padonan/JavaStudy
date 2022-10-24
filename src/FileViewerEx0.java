import java.io.*;

public class FileViewerEx0 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/data2.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);

        bis.read();

    }
}
