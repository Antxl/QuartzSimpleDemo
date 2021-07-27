package com.antxl.simplequartzdemo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String now(){
        return format.format(new Date());
    }

    public static String now(SimpleDateFormat format){
        return format.format(new Date());
    }
}
