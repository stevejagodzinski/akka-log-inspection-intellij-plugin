package com.github.stevejagodzinski.aliip.actor.custom;

import com.github.stevejagodzinski.aliip.actor.custom.base.LoggingActor;

@SuppressWarnings("unused")
// Configured with:
// Additional Akka Log Class: com.github.stevejagodzinski.aliip.actor.custom.base.LoggingActor.MessageDiagnosticLoggingAdapter
public class EnhancedCustomLoggingActor extends LoggingActor {

  @Override
  public Receive createReceive() {
    return null;
  }

  // Not OK
  private void doesLogging(final Exception e) {log().enhance(new Object()).error("Log exception after message", e);}
  private void tooManyParameters0() {log().enhance(new Object()).error("Too many, no placeholder", new Object());}
  private void tooManyParameters1() {log().enhance(new Object()).error("Too many, one placeholder {}", new Object(), new Object());}
  private void tooManyParameters2() {log().enhance(new Object()).error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
  private void tooFewParameters() {log().enhance(new Object()).error("Too {} few, two placeholders {}", new Object());}
  private void tooFewParameters1() {log().enhance(new Object()).error("Too few, one placeholder {}");}

  // Not OK - with message
  private final Object message = new Object();
  private void doesLoggingWithMessage(final Exception e) {log(message).error("Log exception after message", e);}
  private void tooManyParameterWithMessagesWithMessage0() {log(message).error("Too many, no placeholder", new Object());}
  private void tooManyParametersWithMessage1() {log(message).error("Too many, one placeholder {}", new Object(), new Object());}
  private void tooManyParametersWithMessage2() {log(message).error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
  private void tooFewParametersWithMessage() {log(message).error("Too {} few, two placeholders {}", new Object());}
  private void tooFewParametersWithMessage1() {log(message).error("Too few, one placeholder {}");}

  // OK
  private void okNoParameters() {log().enhance(new Object()).error("ok");}
  private void okOneParameter() {log().enhance(new Object()).error("ok {}", new Object());}
  private void okTwoParameters() {log().enhance(new Object()).error("ok {}, {}", new Object(), new Object());}
  private void okExceptionFirst() {log().enhance(new Object()).error(new Exception(), "Ok");}
  private void okExceptionFirstOneParameter() {log().enhance(new Object()).error(new Exception(), "Ok {}", new Object());}

}
