package case_study.untils.validate;

import case_study.untils.validate.exception.EmployeeException;

public class ValidateEmp {
    private static String regex="";
    public static void validateLevel(String level) throws EmployeeException {
        regex="()";
        if (!level.matches(regex)){
            throw new EmployeeException("trình độ của nhân viên phải bao gồm trung cấp,cao đẳng,đại học,sau đại học");
        }
    }
    public static void validatePosition(String pos) throws EmployeeException{
        regex="(lễ tân||phục vụ||chuyên viên||giám sát||quản lý||giám đốc)";
        if (!pos.matches(regex)){
            throw new EmployeeException("vị trí nhân viên phải bao gồm lễ tân,phục vụ,chuyên viên,giám sát,quản lý,giám đốc");
        }
    }
    public static void validateDate(String date) throws EmployeeException{
        regex="^(0[1-9]|[12][0-9]|3[0-1])[/|-](0[1-9]|1[012])[/|-](19[0-9]{2}|200[0123])$";
        if (!date.matches(regex)){
            throw new EmployeeException("nhân viên phải có tuổi lớn hơn 18 và nhỏ hơn 100 tuổi");
        }
    }
    public static void validateIdCard(String idCard) throws EmployeeException{
        regex="[0-9]{9}";
        if (!idCard.matches(regex)){
            throw new EmployeeException("Số CMND phải bao gồm 9 số");
        }
    }
    public static void validateEmail(String email) throws EmployeeException{
        regex="^[a-zA-Z][\\w]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (!email.matches(regex)){
            throw new EmployeeException("email có định dạng là xxx@xxx.xxx");
        }
    }
    public static boolean validateSalary(double salary){
        return salary>0;
    }
}
