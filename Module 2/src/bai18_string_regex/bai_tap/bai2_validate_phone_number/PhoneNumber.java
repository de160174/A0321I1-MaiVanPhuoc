package bai18_string_regex.bai_tap.bai2_validate_phone_number;

import org.junit.runners.Parameterized;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static final String PHONE_NUMBER_REGEX="^[(]\\d{2}[)][-][(]\\d{10}[)]$";

    public PhoneNumber(){

    }
    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
