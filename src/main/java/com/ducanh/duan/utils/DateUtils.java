package com.ducanh.duan.utils;

import java.io.File;
import java.util.Calendar;

public class DateUtils {
    public static String getStringDateOS() {
        Calendar calendar = Calendar.getInstance();
        StringBuilder stringTimer = new StringBuilder("");

        stringTimer.append(calendar.get(Calendar.YEAR));
        stringTimer.append(File.separator);
        stringTimer.append(calendar.get(Calendar.MONTH));
        stringTimer.append(File.separator);
        stringTimer.append(calendar.get(Calendar.DAY_OF_MONTH));

        return  stringTimer.toString() ;
    }
}
