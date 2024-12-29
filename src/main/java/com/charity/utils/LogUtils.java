package com.charity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印日志工具
 * <p>

 *
 * 
 */
public class LogUtils {
    private static Logger logger;

    private LogUtils() {
    }

    public static Logger getInstance(Class c) {
        return logger = LoggerFactory.getLogger(c);
    }
}
