package com.github.stevejagodzinski.aliip.actor;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

@SuppressWarnings("unused")

public class ExceptionActor extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {return new ReceiveBuilder().build();}
    // Not OK
    private void exceptionAfterErrorMessageNoPlaceholder(final Exception e) {log().error("Log exception after message", e);}
    private void exceptionAfterErrorMessage(final Exception e) {log().error("Log exception after message {}", e);}
    private void exceptionAfterErrorMessageWithPlaceholder(final Exception e) {log().error("Log exception after message {} {}", new Object(), e);}

    // Exception OK, Placeholder NOK
    private void exceptionAfterWarnMessageWithPlaceholder(final Exception e) {log().warning("Log exception after message {}", new Object(), e);}
    private void exceptionAfterWarnMessageWithItsPlaceholder(final Exception e) {log().warning("Log exception after message {} {}", e);}

    // OK, warn, but exception is provided as placeholder
    private void exceptionAfterWarnMessageWithExceptionAndObjPlaceholder(final Exception e) {log().warning("Log exception after message {} {}", new Object(), e);}
    private void exceptionAfterWarnMessageWithExceptionPlaceholder(final Exception e) {log().warning("Log exception after message {}", e);}

    // Ok
    private void exceptionAfterErrorMessageWithItsPlaceholder(final Exception e) {log().error(e, "Log exception after message");}
    private void exceptionBeforeErrorMessage(final Exception e) {log().error(e, "Log exception after message");}
}
