package com.github.stevejagodzinski.aliip.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Slf4jClass {
    private static final Logger LOG = LoggerFactory.getLogger(Slf4jClass.class);

    public static void handleException(final Exception e) {
        LOG.error("Log the exception using a placeholder {} {}", new Object());
    }
}
