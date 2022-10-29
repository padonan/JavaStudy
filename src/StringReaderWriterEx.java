import java.io.*;

public class StringReaderWriterEx {
    public static void main(String[] args) {
        String inputData = "ABCD";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        try {
            while((data = input.read()) != -1) {
                System.out.println(data);
                output.write(data);
            }
        } catch (IOException e) {}

        System.out.println("Input Data :" + inputData);
        System.out.println("Output Data :" + output.toString());
        System.out.println("Output Data :" + output.getBuffer().toString());
    }
}
