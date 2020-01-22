# akka-log-inspection-plugin

## What
This IntelliJ plugin provides code inspections to highlight invocations to Akka's logging framework where the number of message placeholders do not match the number of arguments passed to the log method.

## Download
#### Directly From Your IDE
Settings/Preferences -> Plugins -> Marketplace -> Search -> Akka Log Inspections

Don't see it? You may be be running an un-supported version of IntelliJ. Currently versions 2019.2 - 2019.3.2+ are supported.
#### From The JetBrainsPlugin Repo
[Akka Log Inspections](https://plugins.jetbrains.com/plugin/13266-akka-log-inspections/)

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

Even within invocations to Akka's logging framework where the Throwable is provided as a placeholder parameter, the stacktrace will not be provided in the log:
```java
log().error("Some message{}, e")
log().warning("Some message{}, e")
log().info("Some message{}, e")
```
Currently this plugin can detect this condition in the log().error case, and will provide a warning.
