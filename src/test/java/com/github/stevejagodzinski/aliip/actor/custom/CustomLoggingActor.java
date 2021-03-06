package com.github.stevejagodzinski.aliip.actor.custom;

import com.github.stevejagodzinski.aliip.actor.custom.base.LoggingActor;

@SuppressWarnings("unused")
// Configured with:
// Additional Akka Log Class: com.github.stevejagodzinski.aliip.actor.custom.base.LoggingActor.MessageDiagnosticLoggingAdapter
public class CustomLoggingActor extends LoggingActor {

  @Override
  public Receive createReceive() {
    return null;
  }

  // Not OK
  private void doesLogging(final Exception e) {log().error("Log exception after message", e);}
  private void tooManyParameters0() {log().error("Too many, no placeholder", new Object());}
  private void tooManyParameters1() {log().error("Too many, one placeholder {}", new Object(), new Object());}
  private void tooManyParameters2() {log().error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
  private void tooFewParameters() {log().error("Too {} few, two placeholders {}", new Object());}
  private void tooFewParameters1() {log().error("Too few, one placeholder {}");}

  // Not OK - with message
  private final Object message = new Object();
  private void doesLoggingWithMessage(final Exception e) {log(message).error("Log exception after message", e);}
  private void tooManyParameterWithMessagesWithMessage0() {log(message).error("Too many, no placeholder", new Object());}
  private void tooManyParametersWithMessage1() {log(message).error("Too many, one placeholder {}", new Object(), new Object());}
  private void tooManyParametersWithMessage2() {log(message).error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
  private void tooFewParametersWithMessage() {log(message).error("Too {} few, two placeholders {}", new Object());}
  private void tooFewParametersWithMessage1() {log(message).error("Too few, one placeholder {}");}

  // OK
  private void okNoParameters() {log().error("ok");}
  private void okOneParameter() {log().error("ok {}", new Object());}
  private void okTwoParameters() {log().error("ok {}, {}", new Object(), new Object());}
  private void okExceptionFirst() {log().error(new Exception(), "Ok");}
  private void okExceptionFirstOneParameter() {log().error(new Exception(), "Ok {}", new Object());}

}
