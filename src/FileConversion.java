import java.io.*;

public class FileConversion {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("src/data3.txt");
            FileWriter fw = new FileWriter("src/sample.txt",true);

            int data = 0;
            while((data=fr.read()) != -1) {
                if(data !='\t' && data != '\n' && data != ' ' && data != '\r')
                    fw.write(data);
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
