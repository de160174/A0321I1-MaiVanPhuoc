package model.service.common;

public class Validate {
    public static String validateCustomerID (String customerID) {
        String message = null;
        String regex = "^KH-[0-9]{4}$";
        if (!customerID.matches(regex)) {
            message = "Vui lòng nhập đúng định dạng : KH-XXXX (X là số 0-9)";
        }
        return message;
    }
    public static String validateServiceID (String serviceID) {
        String message = null;
        String regex = "^DV-[0-9]{4}$";
        if (!serviceID.matches(regex)) {
            message = "Vui lòng nhập đúng định dạng : DV-XXXX (X là số 0-9)";
        }
        return message;
    }
    public static String validatePhone (String phone) {
        String message = null;
        String regex = "^090[0-9]{7}$|^091[0-9]{7}$";
        if (!phone.matches(regex)) {
            message = "Vui lòng nhập đúng định dạng :090xxxxxxx hoặc 091xxxxxxx";
        }
        return message;
    }
    public static String validateIDCard (String idCard) {
        String message = null;
        String regex = "^[0-9]{9}$|^[0-9]{12}$";
        if (!idCard.matches(regex)) {
            message = "Vui lòng nhập đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX ";
        }
        return message;
    }
    public static String validateEmail (String email) {
        String message = null;
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(regex)) {
            message = "Vui lòng nhập đúng định dạng email ";
        }
        return message;
    }
    public static String validateNumberOfFloors (int numberOfFloors) {
        String message = null;
        if (numberOfFloors < 0 ) {
            message = "Vui lòng nhập số nguyên dương!";
        }
        return message;
    }
    public static String validateSalary(double salary) {
        String message = null;
        if (salary < 0 ) {
            message = "Vui lòng nhập số dương!";
        }
        return message;
    }
    public static String validateCost(double cost) {
        String message = null;
        if (cost < 0 ) {
            message = "Vui lòng nhập số dương!";
        }
        return message;
    }
    public static String validateDeposit(double deposit) {
        String message = null;
        if (deposit < 0 ) {
            message = "Vui lòng nhập số dương!";
        }
        return message;
    }

    public static String validateTotalMoney(double totalMoney) {
        String message = null;
        if (totalMoney < 0 ) {
            message = "Vui lòng nhập số dương!";
        }
        return message;
    }
}
