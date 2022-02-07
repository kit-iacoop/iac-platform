package com.web.util;

import org.thymeleaf.util.StringUtils;

public class StringUtil {
    public static String pagingUrlFormatWithKey(String path, String key) {
        StringBuffer stringBuffer = new StringBuffer()
                .append(path)
                .append("?page=%d");
        if (!StringUtils.isEmptyOrWhitespace(key))
            stringBuffer
                    .append("&key=")
                    .append(key);
        return stringBuffer.toString();
    }
}
