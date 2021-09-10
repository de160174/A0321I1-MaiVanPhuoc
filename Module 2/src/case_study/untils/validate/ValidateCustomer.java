package case_study.untils.validate;

import case_study.untils.validate.exception.CustomerException;

public class ValidateCustomer {
    private static String regex="";
    public static void validateType(String type) throws CustomerException {
        regex="(Diamond||Platinium||Gold||Silver||Member)";
        if(!type.matches(regex)){
            throw new CustomerException("loại khách hàng phải bao gồm Diamond,Platinium,Gold,Silver,Member");
        }
    }
    public static void validateDate(String date) throws CustomerException{
        regex="^(0[1-9]|[12][0-9]|3[0-1])[/|-](0[1-9]|1[012])[/|-](19[2-9][0-9]|200[0123])$";
        if(!date.matches(regex)) {
            throw new CustomerException("người dùng phải có tuổi lớn hơn 18 và nhỏ hơn 100 tuổi");
        }
    }
    public static void validateIdCard(String idCard) throws CustomerException{
        regex="[0-9]{9}";
        if (!idCard.matches(regex)){
            throw new CustomerException("Số CMND phải bao gồm 9 số");
        }
    }
    public static void validateEmail(String email) throws CustomerException{
        regex="^[a-zA-Z][\\w]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (!email.matches(regex)){
            throw new CustomerException("email có định dạng là xxx@xxx.xxx");
        }
    }
}
