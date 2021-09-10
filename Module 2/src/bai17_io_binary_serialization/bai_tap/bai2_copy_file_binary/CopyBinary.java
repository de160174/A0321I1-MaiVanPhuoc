package bai17_io_binary_serialization.bai_tap.bai2_copy_file_binary;

import java.io.*;

public class CopyBinary {
    public static void copyFile(File source, File target) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (!source.exists()) {
            throw new FileNotFoundException("File không tồn tại!!!");
        } else {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            System.out.println("Copy thành công");
        }
    }

    public static void main(String[] args){
        try {
            String source = ("src\\bai17_io_binary_serialization\\bai_tap\\bai2_copy_file_binary\\source.csv");
            String target = ("src\\bai17_io_binary_serialization\\bai_tap\\bai2_copy_file_binary\\target.csv");
            File sourceFile = new File(source);
            File targetFile = new File(target);
            copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
