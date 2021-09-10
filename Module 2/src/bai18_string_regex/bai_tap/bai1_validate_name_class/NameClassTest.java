package bai18_string_regex.bai_tap.bai1_validate_name_class;

public class NameClassTest {
    private static NameClassExample nameClassExample;
    private static final String[] validName=new String[]{"C0318G","A0321I"};
    private static final String[] invalidName=new String[]{"M0318G","P0323A"};

    public static void main(String[] args) {
        nameClassExample=new NameClassExample();
        for (String name : validName){
            boolean isvalid=nameClassExample.validate(name);
            System.out.println("Email is " + name +" is valid: "+ isvalid);
        }
        for (String name : invalidName) {
            boolean isvalid = nameClassExample.validate(name);
            System.out.println("Email is " + name +" is valid: "+ isvalid);
        }
    }
}
