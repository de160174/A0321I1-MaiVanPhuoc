package bai16_io_text_file.bai_tap.bai1_copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        File inputFile=new File("src\\bai16_io\\bai_tap\\bai1_copy_file\\inputFile.txt");
        File outputFile=new File("src\\bai16_io\\bai_tap\\bai1_copy_file\\outputFile.txt");

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(outputFile));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                bufferedWriter.write(line +"\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
