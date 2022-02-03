package com.web.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    public static long calcDday(String date) {
        return LocalDate.now().until(toLocalDate(date), ChronoUnit.DAYS);
    }

    public static long passedDay(String date) {
        return toLocalDate(date).until(LocalDate.now(), ChronoUnit.DAYS);
    }

    public static String dotStyle(String date) {
        return toLocalDate(date).format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    public static String dotStyleWithTime(String date) {
        return toLocalDateTime(date).format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }

    public static String dotStyleWithoutTime(String date) {
        return toLocalDateTime(date).format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    public static LocalDate toLocalDate(String date) {
        if (date.length() > 10) {
            return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    public static LocalDateTime toLocalDateTime(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
