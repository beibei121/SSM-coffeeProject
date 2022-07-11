package org.ccunix.coffee.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSwitchUtil {
    /**
     * 日期转换存字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String parseString(Date date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * 字符串转换成日期
     * @param source
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String source,String pattern) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.parse(source);
    }
}
