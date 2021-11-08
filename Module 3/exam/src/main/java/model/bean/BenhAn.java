package model.bean;

public class BenhAn {
    private String benh_an_id;
    private String benh_nhan_name;
    private String ngay_nhap;
    private String ngay_ra;
    private String ly_do;
    private String benh_nhan_id;

    public BenhAn() {
    }

    public BenhAn(String benh_an_id, String benh_nhan_name, String ngay_nhap, String ngay_ra, String ly_do, String benh_nhan_id) {
        this.benh_an_id = benh_an_id;
        this.benh_nhan_name = benh_nhan_name;
        this.ngay_nhap = ngay_nhap;
        this.ngay_ra = ngay_ra;
        this.ly_do = ly_do;
        this.benh_nhan_id = benh_nhan_id;
    }

    public String getBenh_an_id() {
        return benh_an_id;
    }

    public void setBenh_an_id(String benh_an_id) {
        this.benh_an_id = benh_an_id;
    }

    public String getBenh_nhan_name() {
        return benh_nhan_name;
    }

    public void setBenh_nhan_name(String benh_nhan_name) {
        this.benh_nhan_name = benh_nhan_name;
    }

    public String getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(String ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }

    public String getNgay_ra() {
        return ngay_ra;
    }

    public void setNgay_ra(String ngay_ra) {
        this.ngay_ra = ngay_ra;
    }

    public String getLy_do() {
        return ly_do;
    }

    public void setLy_do(String ly_do) {
        this.ly_do = ly_do;
    }

    public String getBenh_nhan_id() {
        return benh_nhan_id;
    }

    public void setBenh_nhan_id(String benh_nhan_id) {
        this.benh_nhan_id = benh_nhan_id;
    }
}
