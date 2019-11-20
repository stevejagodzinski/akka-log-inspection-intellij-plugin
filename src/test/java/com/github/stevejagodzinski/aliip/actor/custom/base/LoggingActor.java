package com.github.stevejagodzinski.aliip.actor.custom.base;

import akka.event.DiagnosticLoggingAdapter;
import akka.event.Logging;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

@SuppressWarnings("unused")
public abstract class LoggingActor extends BaseActor {
  private final MessageDiagnosticLoggingAdapter log = new MessageDiagnosticLoggingAdapter(Logging.getLogger(this));

  public MessageDiagnosticLoggingAdapter log() {
    return log;
  }

  public MessageDiagnosticLoggingAdapter log(Object message) {
    return log;
  }

  public static class MessageDiagnosticLoggingAdapter {
    private DiagnosticLoggingAdapter log;

    MessageDiagnosticLoggingAdapter(DiagnosticLoggingAdapter log) {
      this.log = log;
    }

    void setMDC(Map<String, Object> mdc) {
      this.log.setMDC(mdc);
    }

    void clearMDC() {
      this.log.clearMDC();
    }

    public MessageDiagnosticLoggingAdapter withDuration(Duration duration) {
      log.setMDC(Collections.emptyMap());
      return this;
    }

    public void error(Throwable throwable, String template, Object... objects) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }

    public void error(Throwable throwable, String template) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }

    public void error(String template, Object... objects) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }

    public void warning(String template, Object... objects) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }

    public void info(String template, Object... objects) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }

    public void debug(String template, Object... objects) {
      throw new UnsupportedOperationException("Method signature exists only for test");
    }
  }
}
