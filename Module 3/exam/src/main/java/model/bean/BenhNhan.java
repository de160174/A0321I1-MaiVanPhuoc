package model.bean;

public class BenhNhan {
    private String benh_nhan_id;
    private String benh_nhan_name;

    public BenhNhan() {
    }

    public BenhNhan(String benh_nhan_id, String benh_nhan_name) {
        this.benh_nhan_id = benh_nhan_id;
        this.benh_nhan_name = benh_nhan_name;
    }

    public String getBenh_nhan_id() {
        return benh_nhan_id;
    }

    public void setBenh_nhan_id(String benh_nhan_id) {
        this.benh_nhan_id = benh_nhan_id;
    }

    public String getBenh_nhan_name() {
        return benh_nhan_name;
    }

    public void setBenh_nhan_name(String benh_nhan_name) {
        this.benh_nhan_name = benh_nhan_name;
    }
}
