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
}
