## How to Find Java Process Id

In Linux, use `ps -C java -o pid`.
In Windows, use `tasklist /m java*`.

With windows task manager, you can identify the processes in the GUI as shown in the screenshot below.

![windows-java-process-id](java-pids.PNG)

On both platforms, use `jps` on the command line also gives the process ids.As shown in the screenshot above, there were 3 processed opened by Eclipse, IntelliJ Idea, and the Maven plugin used by IntelliJ.

## JVM options

On the command line, use `java [options] ApplicationName`, e.g., `java -Xms256m -Xmx JavaClass`. Use `java -help` and `java -X` to see available options.

Eclipse settings file location is at installation directory C:\Users\username\eclipse\jee-neon\eclipse\eclipse.ini. For IntelliJ Idea, vmoptions file is at C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2016.1.2\bin\idea64.exe.vmoptions.
