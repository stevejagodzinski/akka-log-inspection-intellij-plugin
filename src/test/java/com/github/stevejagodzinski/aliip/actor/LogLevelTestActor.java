package com.github.stevejagodzinski.aliip.actor;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

@SuppressWarnings("unused")
public class LogLevelTestActor extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {return new ReceiveBuilder().build();}
    // Not OK
    private void doesErrorLogging(final Exception e) {log().error("Log exception after message", e);}
    private void tooManyErrorParameters0() {log().error("Too many, no placeholder", new Object());}
    private void tooManyErrorParameters1() {log().error("Too many, one placeholder {}", new Object(), new Object());}
    private void tooManyErrorParameters2() {log().error("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
    private void tooFewErrorParameters() {log().error("Too {} few, two placeholders {}", new Object());}
    private void tooFewErrorParameters1() {log().error("Too few, one placeholder {}");}

    private void doesWarnLogging(final Exception e) {log().warning("Log exception after message", e);}
    private void tooManyWarnParameters0() {log().warning("Too many, no placeholder", new Object());}
    private void tooManyWarnParameters1() {log().warning("Too many, one placeholder {}", new Object(), new Object());}
    private void tooManyWarnParameters2() {log().warning("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
    private void tooFewWarnParameters() {log().warning("Too {} few, two placeholders {}", new Object());}
    private void tooFewWarnParameters1() {log().warning("Too few, one placeholder {}");}

    private void doesInfoLogging(final Exception e) {log().info("Log exception after message", e);}
    private void tooManyInfoParameters0() {log().info("Too many, no placeholder", new Object());}
    private void tooManyInfoParameters1() {log().info("Too many, one placeholder {}", new Object(), new Object());}
    private void tooManyInfoParameters2() {log().info("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
    private void tooFewInfoParameters() {log().info("Too {} few, two placeholders {}", new Object());}
    private void tooFewInfoParameters1() {log().info("Too few, one placeholder {}");}

    private void doesDebugLogging(final Exception e) {log().debug("Log exception after message", e);}
    private void tooManyDebugParameters0() {log().debug("Too many, no placeholder", new Object());}
    private void tooManyDebugParameters1() {log().debug("Too many, one placeholder {}", new Object(), new Object());}
    private void tooManyDebugParameters2() {log().debug("Too {} many, two placeholders {}", new Object(), new Object(), new Object());    }
    private void tooFewDebugParameters() {log().debug("Too {} few, two placeholders {}", new Object());}
    private void tooFewDebugParameters1() {log().debug("Too few, one placeholder {}");}
    
    // OK
    private void okNoErrorParameters() {log().error("ok");}
    private void okOneErrorParameter() {log().error("ok {}", new Object());}
    private void okTwoErrorParameters() {log().error("ok {}, {}", new Object(), new Object());}
    private void okErrorExceptionFirst() {log().error(new Exception(), "Ok");}
    private void okErrorExceptionFirstOneParameter() {log().error(new Exception(), "Ok {}", new Object());}

    private void okNoWarnParameters() {log().warning("ok");}
    private void okOneWarnParameter() {log().warning("ok {}", new Object());}
    private void okTwoWarnParameters() {log().warning("ok {}, {}", new Object(), new Object());}

    private void okNoInfoParameters() {log().info("ok");}
    private void okOneInfoParameter() {log().info("ok {}", new Object());}
    private void okTwoInfoParameters() {log().info("ok {}, {}", new Object(), new Object());}

    private void okNoDebugParameters() {log().debug("ok");}
    private void okOneDebugParameter() {log().debug("ok {}", new Object());}
    private void okTwoDebugParameters() {log().debug("ok {}, {}", new Object(), new Object());}
}
