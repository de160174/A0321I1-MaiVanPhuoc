package bai16_io_text_file.thuc_hanh.sum_of_number;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath){
        try {
            File file=new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            //doc tung dong cua file va tien hanh cong tong lai
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line="";
            int sum=0;
            while ((line=br.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng = "+sum);
        }catch (Exception e){
            System.out.println("File không tồn tại!!");
        }
    }

    public static void main(String[] args) {
        System.out.println("nhập đường dẫn file");
        Scanner scanner=new Scanner(System.in);
        String path=scanner.nextLine();
        ReadFileExample readFileExample=new ReadFileExample();
        readFileExample.readFileText(path
        );
    }
}
