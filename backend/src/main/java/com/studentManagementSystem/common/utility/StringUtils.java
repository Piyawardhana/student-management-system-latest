package com.studentManagementSystem.common.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
    static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static boolean isBlank(String value) {
        return ( value == null || value.trim().equals(""));
    }

    public static boolean isBlank(Object value) {
        return ( value == null || value.toString().trim().equals(""));
    }

    public static boolean isNull(String value) {
        return (value == null);
    }

    public static boolean isNull(Object value) {
        return (value == null);
    }

    public static boolean isEmpty(String value) {
        return ( value.trim().equals(""));
    }

    public static boolean isEmpty(Object value) {
        return ( value.toString().trim().equals(""));
    }

    public static boolean isNotEmpty(String value) {
        return (!value.trim().equals(""));
    }

    public static boolean isNotEmpty(Object value) {
        return (!value.toString().trim().equals(""));
    }

    public static boolean isNotNull(String value) {
        return (value != null);
    }

    public static boolean isNotNull(Object value) {
        return (value != null);
    }

    public static boolean isNotBlank(String value) {
        return (value != null && !value.trim().equals(""));
    }

    public static boolean isNotBlank(Object value) {
        return (value != null && !value.toString().trim().equals(""));
    }
}
