package com.accenture.students.validations;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class PhoneNumberValidation {
    public static boolean isValid(String s)
    {


        if(s.length()<=9 && s.length()>=13){
            return  false;
        }
        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // 1)if length of the string is equal to 10
        // 2) Then contains 6,7 or 8 or 9.
        // 3) Then contains 9 digits
        if(s.length()==10){
            Pattern p = Pattern.compile("[6-9][0-9]{9}");
            Matcher m = p.matcher(s);
            return (((Matcher) m).find() && m.group().equals(s));
        }
        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // 1) Begins with 0 or 91
        // 2) Then contains 6,7 or 8 or 9.
        // 3) Then contains 9 digits
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(s);
        return (((Matcher) m).find() && m.group().equals(s));
    }

    /**
     *
     * @param str
     * @return
     *
     * if number contains 12 digits then below method trim first 2 numbers and add 10 numbers only.
     */
    public String trimTwoNumbersFromThePhoneNumber(String str) {

        if (str.length() == 10) {
            return str;
        } else {

            return str.substring(2);
        }
    }

}
