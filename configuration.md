# Java

Use Java 1.8, Jesse has JDK 1.8.0.60 from Oracle.

# IDE

IntelliJ Idea community edition 2016.3.3.

## Java Level setting

- File - Settings - Compiler, Java Compiler
- File - Project Structure - Project Language Level, Module - Source Tab, Language Level
- Maven

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```


## Maven Loading Archetype List in IntelliJ For Ever

[see this link at stack overflow](http://stackoverflow.com/questions/17421103/create-a-maven-project-in-intellij-idea-12-but-alway-in-the-loading-archetype-l)

- update maven repo: Settings->Maven->Repositories - select maven's Central repo (if it's there; otherwise you should add it (http://repo.maven.apache.org/maven2/)) and press Update button.
- Maven->Importing: "VM options for importer" to -Xmx1024m (default is -Xmx512m and it's not enough). 
