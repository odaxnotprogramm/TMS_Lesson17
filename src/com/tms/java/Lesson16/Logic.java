package com.tms.java.Lesson16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
    public boolean checkIP (String ip){
        Pattern pattern = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
    public String checkPhoneNumber (String text){
        Pattern pattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) return matcher.group();
        else return "None";
    }

    public String checkEmail (String text){
        Pattern pattern = Pattern.compile("([a-zA-Z0-9+_.-]+)@([a-zA-Z0-9+_.-]+)");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) return matcher.group();
        else return "None";
    }

    public String checkDocumentNumber(String text){
        Pattern pattern = Pattern.compile("((\\d{4})-([a-zA-Z]|[а-яА-Я]){3}-){2}\\d([a-zA-Z]|[а-яА-Я])\\d([a-zA-Z]|[а-яА-Я])");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) return matcher.group();
        else return "None";
    }
}
