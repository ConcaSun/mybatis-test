package com.usoft.suntg.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by ConcaSun on 2019/4/17.
 */
public class DateUtil {
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_SIMPLE_DATE = "yyyyMMdd";

    private DateUtil() {
    }

    /***
     * 获取当前日期
     * @param pattern 格式：yyyyMMdd etc.
     * @return
     */
    public static String getCurrentDate(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        return dateTimeFormatter.format(localDateTime);
    }
}
