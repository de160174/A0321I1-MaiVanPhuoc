package bai16_io_text_file.bai_tap.bai2_read_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    public static void main(String[] args) {
        String line="";
        String Path="src\\bai16_io\\bai_tap\\bai2_read_csv\\source.csv";
        writeCsv(Path);
        List<Country> list=new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(Path));
            Country countries=null;
            while ((line=bufferedReader.readLine())!=null){
                String[] country=line.split(",");
                countries = new Country(country[0],country[1],country[2],country[3],country[4],country[5]);
                list.add(countries);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void writeCsv(String path){
        try {
            Country country=new Country("1.0.0.0","1.0.7.25","1221","1223","VN","Việt Nam");
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(country.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
