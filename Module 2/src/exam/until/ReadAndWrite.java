package exam.until;


import exam.model.BenhAnThuong;
import exam.model.BenhAnVIP;

import java.io.*;
import java.util.*;

public class ReadAndWrite {
    static final String PATH="D:\\BTcodegym\\Module2\\src\\exam\\data\\medical_records.csv";

    static final String PATH_VIP="D:\\BTcodegym\\Module2\\src\\exam\\data\\medical_recordsVIP.csv";
    public static void writeThuong(String path, ArrayList<BenhAnThuong> benhAnList, boolean check){
        try {
            FileWriter fileWriter=new FileWriter(PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (BenhAnThuong benhAn:benhAnList){
                bufferedWriter.write(benhAn.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeVIP(String path, ArrayList<BenhAnVIP> benhAnList, boolean check){
        try {
            FileWriter fileWriter=new FileWriter(PATH_VIP,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (BenhAnVIP benhAn:benhAnList){
                bufferedWriter.write(benhAn.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<BenhAnThuong> readThuong(String Path){
        ArrayList<BenhAnThuong> benhAnList=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                BenhAnThuong benhAn=new BenhAnThuong(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],Double.parseDouble(arr[7]));
                benhAnList.add(benhAn);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return benhAnList;
    }
    public static ArrayList<BenhAnVIP> readVIP(String Path){
        ArrayList<BenhAnVIP> benhAnList=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(PATH_VIP);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                BenhAnVIP benhAn=new BenhAnVIP(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]);
                benhAnList.add(benhAn);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return benhAnList;
    }
}
