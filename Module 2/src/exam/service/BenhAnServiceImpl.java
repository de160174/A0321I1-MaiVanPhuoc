package exam.service;


import exam.model.BenhAn;
import exam.model.BenhAnThuong;
import exam.model.BenhAnVIP;
import exam.until.BenhAnException;
import exam.until.ReadAndWrite;
import exam.until.ValidateBenhAN;

import java.util.ArrayList;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService {
    static Scanner scanner=new Scanner(System.in);
    static final String PATH="D:\\BTcodegym\\Module2\\src\\exam\\data\\medical_records.csv";
    static final String PATH_VIP="D:\\BTcodegym\\Module2\\src\\exam\\data\\medical_recordsVIP.csv";
    @Override
    public void addThuong() {
        ArrayList<BenhAnThuong> list=new ArrayList<>();
        System.out.println("nhập STT bệnh án");
        int stt=scanner.nextInt();
        scanner.skip("\\R");
        String benhAnId="";
        while (true){
            try {
                System.out.println("nhập mã bệnh án");
                benhAnId=scanner.nextLine();
                ValidateBenhAN.validateBenhAn(benhAnId);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        String benhNhanId="";
        while (true){
            try {
                System.out.println("nhập mã bệnh nhân");
                benhNhanId=scanner.nextLine();
                ValidateBenhAN.validateBenhNhan(benhNhanId);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("nhập tên bệnh nhân");
        String benhNhanName=scanner.nextLine();
        String ngayNhap="";

        while (true){
            try {
                System.out.println("ngày nhập viện");
                ngayNhap=scanner.nextLine();
                ValidateBenhAN.validateNgay(ngayNhap);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        String ngayRa="";
        while (true){
            try {System.out.println("ngày ra viện");
                ngayRa=scanner.nextLine();
                ValidateBenhAN.validateNgay(ngayRa);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("lý do nhập viện");
        String lyDo=scanner.nextLine();
        System.out.println("phí nằm viện");
        Double vienPhi=scanner.nextDouble();
        list.add(new BenhAnThuong(stt,benhAnId,benhNhanId,benhNhanName,ngayNhap,ngayRa,lyDo,vienPhi));
        ReadAndWrite.writeThuong(PATH,list,true);
        xemThuong();
    }
    @Override
    public void addVIP() {
        ArrayList<BenhAnVIP> list=new ArrayList<>();
        System.out.println("nhập STT bệnh án");
        int stt=scanner.nextInt();
        scanner.skip("\\R");
        String benhAnId="";
        while (true){
            try {
                System.out.println("nhập mã bệnh án");
                benhAnId=scanner.nextLine();
                ValidateBenhAN.validateBenhAn(benhAnId);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        String benhNhanId="";
        while (true){
            try {
                System.out.println("nhập mã bệnh nhân");
                benhNhanId=scanner.nextLine();
                ValidateBenhAN.validateBenhNhan(benhNhanId);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("nhập tên bệnh nhân");
        String benhNhanName=scanner.nextLine();
        String ngayNhap="";

        while (true){
            try {
                System.out.println("ngày nhập viện");
                ngayNhap=scanner.nextLine();
                ValidateBenhAN.validateNgay(ngayNhap);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        String ngayRa="";
        while (true){
            try {System.out.println("ngày ra viện");
                ngayRa=scanner.nextLine();
                ValidateBenhAN.validateNgay(ngayRa);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("nhập tên bệnh nhân");
        System.out.println("lý do nhập viện");
        String lyDo=scanner.nextLine();
        System.out.println("loại VIP");
        String loai=scanner.nextLine();
        String thoiHan="";
        while (true){
            try {
                System.out.println("thời hạn VIP");
                thoiHan=scanner.nextLine();
                ValidateBenhAN.validateNgay(thoiHan);
                break;
            }catch (BenhAnException e){
                System.err.println(e.getMessage());
            }
        }

        list.add(new BenhAnVIP(stt,benhAnId,benhNhanId,benhNhanName,ngayNhap,ngayRa,lyDo,loai,thoiHan));
        ReadAndWrite.writeVIP(PATH_VIP,list,true);
        xemVIP();
    }

    @Override
    public void xoaThuong() {
        ArrayList<BenhAnThuong> list=ReadAndWrite.readThuong(PATH);
        System.out.println("nhập mã bệnh án muốn xóa");
        String inputId=scanner.nextLine();
        for (BenhAn benhAn:list){
            if(benhAn.getMaBenhAn().equals(inputId)){
                list.remove(benhAn);
            }
        }
        xemThuong();
    }
    @Override
    public void xoaVIP() {
        ArrayList<BenhAnVIP> list=ReadAndWrite.readVIP(PATH_VIP);
        System.out.println("nhập mã bệnh án muốn xóa");
        String inputId=scanner.nextLine();
        for (BenhAnVIP benhAn:list){
            if(benhAn.getMaBenhAn().equals(inputId)){
                list.remove(benhAn);
            }
        }
        xemVIP();
    }

    @Override
    public void xemThuong() {
        ArrayList<BenhAnThuong> list=ReadAndWrite.readThuong(PATH);
        for(BenhAnThuong benhAn:list){
            System.out.println(benhAn.showInfo());
        }
    }
    @Override
    public void xemVIP() {
        ArrayList<BenhAnVIP> list=ReadAndWrite.readVIP(PATH_VIP);
        for(BenhAnVIP benhAn:list){
            System.out.println(benhAn.showInfo());
        }
    }
}
