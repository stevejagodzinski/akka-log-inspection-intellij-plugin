package com.github.stevejagodzinski.actor;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

@SuppressWarnings("unused")
public class TestActor extends AbstractLoggingActor {

    @Override
    public Receive createReceive() {
        return new ReceiveBuilder().build();
    }

    private void doesLogging(final Exception e) {
        log().error("Log exception after message", e);
    }
}
