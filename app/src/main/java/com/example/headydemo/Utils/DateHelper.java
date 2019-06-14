package com.example.headydemo.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    /*
 This method is use to convert date string to date object
 @param dateString
 @param dateFormat
  */
    public static Date getDateObj(String dateString, String dateFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            Date date = simpleDateFormat.parse(dateString);
            return date;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getDateString(Date date, String dateFormate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormate);
        return simpleDateFormat.format(date);
    }
}


