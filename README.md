# akka-log-inspection-plugin

Akka's logging library does not follow conventional the SLF4J pattern:
```java
LOG.error("Some message", exception);
```

Exceptions must be logged in one of the following ways:
```java
log().error(exception, "Message");
log().error("Message {}", exception);
log().error(exception, "Message with parameters {} {}", param1, param2);
log().error("Message with parameters {} {} {}", param1, param2, exception);
```
WARN, INFO, and DEBUG **do** log follow SLF4J's pattern:
```java
log().info("Message with parameters {} {}", param1, param2);
```

**However**, SLF4J has an advantage. Tooling like SonarLint/SonarQube can detect cases where the number of placeholders do not match the number of parameters. Take the following example:
```java
log().info("Message {} received from {}", message);
```

We forgot to include the sender as a parameter to the log method.

In the next example we pass too many arguments to the log method:
```java
log().info("Message {} received from {}", message, sender(), System.currentTimeMillis());
```

This plugin will allow you to provide code inspections to highlight invocations to akka's logging framework where the number of message placeholders do not match the number of arguments passed to the log method.