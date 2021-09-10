package case_study.untils.validate;

import case_study.untils.validate.exception.ServiceException;

public class ValidateService {
    private static String regex="";
    public static void validateVilla(String idVilla) throws ServiceException {
        regex="^SVVL-[0-9]{4}$";
        if (!idVilla.matches(regex)){
            throw new ServiceException("Mã dịch vụ phải đúng định dạng SVVL-YYYY, với YYYY là các số từ 0-9");
        }
    }
    public static void validateHouse(String idHouse)throws ServiceException{
        regex="^SVHO-[0-9]{4}$";
        if (!idHouse.matches(regex)){
            throw new ServiceException("Mã dịch vụ phải đúng định dạng SVHO-YYYY, với YYYY là các số từ 0-9");
        }
    }
    public static void validateRoom(String idRoom)throws ServiceException{
        regex="^SVRO-[0-9]{4}$";
        if (!idRoom.matches(regex)){
            throw new ServiceException("Mã dịch vụ phải đúng định dạng SVRO-YYYY, với YYYY là các số từ 0-9");
        }
    }
    public static void nameService(String name)throws ServiceException{
        regex="^[A-Z]+([a-z]+\\s)*[a-z]{2,}";
        if (!name.matches(regex)){
            throw new ServiceException("Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường");
        }
    }
    public static boolean checkArea(double area){
        return area>30;
    }
    public static boolean checkPeople(int numPeople){
        return numPeople>0 && numPeople<20;
    }
    public static boolean checkRentCost(double rentCost){
        return rentCost>0;
    }
    public static boolean checkFloor(int floor){
        return floor>0;
    }
    public static void checkRentType(String type)throws ServiceException{
        regex="(năm||tháng||ngày||giờ)";
        if (!type.matches(regex)){
            throw new ServiceException("kiểu thuê phải bao gồm năm,tháng,ngày,giờ");
        }
    }
    public static void checkRoomStandard(String standard)throws ServiceException{
        regex="(standard||delux||super||vip)";
        if (!standard.matches(regex)){
            throw new ServiceException("tiêu chuẩn phòng phải bao gồm standard,delux,super,vip");
        }
    }
}
