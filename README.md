# akka-log-inspection-plugin

## What
This IntelliJ plugin provides code inspections to highlight invocations to Akka's logging framework where the number of message placeholders do not match the number of arguments passed to the log method.
## Why
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

In the example above, sender was not provided as a parameter to the log method. The template expects two parameters, but only one is provided.

In the next example too many arguments are passed to the log method:
```java
log().info("Message {} received from {}", message, sender(), System.currentTimeMillis());
```
With this plugin, such violations will be highlighted within the IntelliJ IDE so that you can know about, and correct these issues early-on.