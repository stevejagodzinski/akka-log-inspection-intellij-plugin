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

    private void tooManyParameters0() {
        log().error("Too many, no placeholder", new Object());
    }

    private void tooManyParameters1() {
        log().error("Too many, one placeholder {}", new Object(), new Object());
    }

    private void tooManyParameters2() {
        log().error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());
    }

    private void tooFewParameters() {
        log().error("Too {} few, two placeholders {}", new Object());
    }

    private void tooFewParameters1() {
        log().error("Too few, one placeholder {}");
    }
}
