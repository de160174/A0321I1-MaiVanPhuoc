package bai17_io_binary_serialization.thuc_hanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyLargeFile {
    private static void copyFileUsingJava7Files(File source,File target) throws IOException {
        Files.copy(source.toPath(),target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source,File target){
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream=new FileInputStream(source);
            outputStream=new FileOutputStream(target);
            byte[] buffer=new byte[1024];
            int length;
            while ((length=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String targetPath = in.nextLine();
        File sourceFile=new File(sourcePath);
        File targetFile=new File(targetPath);
        try {
            copyFileUsingJava7Files(sourceFile,targetFile);
            //copyFileUsingStream(sourceFile,targetFile);
            System.out.println("copy thành công");
        } catch (IOException e) {
            System.out.println("không thể copy file");
            System.out.println(e.getMessage());
        }
    }
}
