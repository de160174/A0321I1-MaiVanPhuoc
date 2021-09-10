package bai18_string_regex.bai_tap.bai1_validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClassExample {
    private static final String CLASS_REGEX="^[APC]+\\d{4,}+[GHIKLM]$";
    public NameClassExample(){

    }
    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(CLASS_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }

}
