package com.web.util;

import java.time.LocalDate;
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

    public static LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }
}
