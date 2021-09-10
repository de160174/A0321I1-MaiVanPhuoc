package exam.until;



public class ValidateBenhAN {
    private static String regex="";
    public static void validateBenhAn(String idBenhAn) throws BenhAnException {
        regex="^BA-[0-9]{3}$";
        if (!idBenhAn.matches(regex)){
            throw new BenhAnException("Mã bệnh án phải đúng định dạng BA-XXX, với XXX là các kí tự số.");
        }
    }
    public static void validateBenhNhan(String idBenhNhan) throws BenhAnException {
        regex="^BN-[0-9]{3}$";
        if (!idBenhNhan.matches(regex)){
            throw new BenhAnException("Mã bệnh án phải đúng định dạng BN-XXX, với XXX là các kí tự số.");
        }
    }public static void validateNgay(String ngay) throws BenhAnException {
        regex="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
        if (!ngay.matches(regex)){
            throw new BenhAnException("Ngày nhập viện, Ngày ra viện, Thời hạn VIP phải đúng định dạng dd/MM/yyyy");
        }
    }
    public static void loaiBenhAn(String type) throws BenhAnException {
        regex="(VIP I|VIP II|VIP III)";
        if (!type.matches(regex)){
            throw new BenhAnException("Với bệnh án VIP thì phần thông tin loại VIP thì được chọn 1 trong 3 gói: VIP I, VIP II, VIP III");
        }
    }
}
