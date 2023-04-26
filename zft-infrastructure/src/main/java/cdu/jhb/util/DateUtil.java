package cdu.jhb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @description: TODO
* @author jhb
* @date 2023/04/26 13:59
* @version 1.0
*/
public class DateUtil {

    /**
     * Date根据format转String
     * @param format
     * @param time
     * @return
     */
    public static String DateToString(String format, Date time){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(time);
    }
}
