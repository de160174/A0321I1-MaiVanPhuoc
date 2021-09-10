package bai18_string_regex.bai_tap.bai2_validate_phone_number;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    private static final String[] validNumber=new String[]{"(84)-(0978489648)"};
    private static final String[] invalidNumber=new String[]{"(a8)-(22222222)"};

    public static void main(String[] args) {
        phoneNumber=new PhoneNumber();
        for (String number : validNumber){
            boolean isvalid=phoneNumber.validate(number);
            System.out.println("Email is " + number +" is valid: "+ isvalid);
        }
        for (String number : invalidNumber) {
            boolean isvalid = phoneNumber.validate(number);
            System.out.println("Email is " + number +" is valid: "+ isvalid);
        }
    }
}
