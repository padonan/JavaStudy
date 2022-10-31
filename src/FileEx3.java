import java.io.*;
import java.util.ArrayList;

public class FileEx3 {

    static int totalFiles = 0;
    static int totalDirs = 0;

    public static void main(String[] args) {
        String src = "src/FileEx3.java";
        if(src.length() != 1) {
            System.out.println("USAGE : java FileEx3 DIRECTORY");
            System.exit(0);
        }

        File dir = new File("src/FileEx3.java");

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        printFileList(dir);

        System.out.println();
        System.out.println("총 " + totalFiles + "개의 파일");
        System.out.println("총 " + totalDirs + "개의 디렉토리");
    }

    public static void printFileList(File dir) {
        System.out.println(dir.getAbsolutePath()+" 디렉토리");
        File[] files = dir.listFiles();

        ArrayList subDir = new ArrayList();

        for(int i=0; i < files.length; i++) {
            String fileName = files[i].getName();

            if(files[i].isDirectory()) {
                fileName = "[" + fileName + "]";
                subDir.add(i+"");
                System.out.println(fileName);
            }

            int dirNum = subDir.size();
            int fileNum = files.length - dirNum;

            totalFiles += fileNum;
            totalDirs += dirNum;

            System.out.println(fileNum + "개의 파일," + dirNum + "개의 디렉토리");
            System.out.println();

            for(int j=0; j < subDir.size(); j++) {
                int index = Integer.parseInt((String) subDir.get(j));
                printFileList(files[index]);
            }
        }
    }
}
