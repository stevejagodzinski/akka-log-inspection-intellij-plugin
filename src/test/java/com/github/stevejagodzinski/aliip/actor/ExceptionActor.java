package com.github.stevejagodzinski.aliip.actor;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

@SuppressWarnings("unused")

public class ExceptionActor extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {return new ReceiveBuilder().build();}
    // Not OK
    private void exceptionAfterErrorMessage(final Exception e) {log().error("Log exception after message {}", e);}
    private void exceptionAfterErrorMessageWithPlaceholder(final Exception e) {log().error("Log exception after message {} {}", new Object(), e);}
    private void exceptionAfterErrorMessageWithItsPlaceholder(final Exception e) {log().error(e, "Log exception after message");}

    private void exceptionAfterWarnMessage(final Exception e) {log().warning("Log exception after message {}", e);}
    private void exceptionAfterWarnMessageWithPlaceholder(final Exception e) {log().warning("Log exception after message {}", new Object(), e);}
    private void exceptionAfterWarnMessageWithItsPlaceholder(final Exception e) {log().warning("Log exception after message {} {}", e);}

    // Ok
    private void exceptionBeforeErrorMessage(final Exception e) {log().error(e, "Log exception after message");}
    private void exceptionBeforeErrorMessageWithPlaceholder(final Exception e) {log().error(e, "Log exception after message {}", new Object());}
}
