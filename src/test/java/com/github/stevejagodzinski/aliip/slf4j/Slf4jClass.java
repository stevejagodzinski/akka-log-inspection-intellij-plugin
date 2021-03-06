package com.github.stevejagodzinski.aliip.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Slf4jClass {
    private static final Logger LOG = LoggerFactory.getLogger(Slf4jClass.class);

    public static void handleExtraPlaceholder(final Exception e) {
        LOG.error("Too many placeholders {} {}", new Object());
    }

    public static void handleExtraParameters(final Exception e) {
        LOG.error("Too many placeholders", new Object());
    }
}
