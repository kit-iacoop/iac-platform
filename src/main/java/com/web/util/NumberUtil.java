package com.web.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtil {
    public static String commaFormat(String num) {
        return NumberFormat.getInstance(Locale.US).format(toLong(num));
    }

    public static long toLong(String num) {
        return Long.parseLong(num);
    }

    public static String companyRegistrationNumberFormat(Long num) {
        return Long.toString(num).replaceAll("(\\d{3})(\\d{2})(\\d{5})", "$1-$2-$3");
    }
}