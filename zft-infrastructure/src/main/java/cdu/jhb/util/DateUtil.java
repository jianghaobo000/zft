package cdu.jhb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @description: 日期工具类
* @author jhb
* @date 2023/04/26 13:59
* @version 1.0
*/
public class DateUtil {

    /**
     * Date根据format转String
     * @param formatStr
     * @param time
     * @return
     */
    public static String DateToString(String formatStr, Date time){
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        return formatter.format(time);
    }

    /**
     * String根据format转Date
     * @param formatStr
     * @param time
     * @return
     */
    public static Date StringToDate(String formatStr,String time){
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
