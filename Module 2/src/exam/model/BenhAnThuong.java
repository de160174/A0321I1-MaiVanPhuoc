package exam.model;

public class BenhAnThuong extends BenhAn{
    private double phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(int STT, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(STT, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return STT +
                "," + maBenhAn +
                "," + maBenhNhan +
                "," + tenBenhNhan +
                "," + ngayNhapVien +
                "," + ngayRaVien +
                "," + lyDoNhapVien +
                "," + phiNamVien;
    }
    public String showInfo() {
        return "BenhAnThuong{" +
                "phiNamVien=" + phiNamVien +
                ", STT=" + STT +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                '}';
    }
}
