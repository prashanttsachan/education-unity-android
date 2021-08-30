package com.ciesta.online.education.util;

import java.util.regex.Pattern;

public class Validation {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
    private static final String PHONE_NO_REGEX = "\\d{5}([- ]*)\\d{6}";

    public static boolean isValidEmail(String email) {
        Pattern pat = Pattern.compile(EMAIL_REGEX);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pat = Pattern.compile(PHONE_NO_REGEX);
        if(phoneNumber == null)
            return false;
        return pat.matcher(phoneNumber).matches();
    }

    public static boolean isValidUserName(String userName) {
        if(isValidEmail(userName)) {
            return true;
        } else return isValidPhoneNumber(userName);
    }
}
