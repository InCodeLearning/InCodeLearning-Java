# Java

Use Java 1.8, Jesse has JDK 1.8.0.60 from Oracle.

# IDE

Jesse uses intelliJ Idea community edition. Anything is ok here, but you should set .gitignore accordingly.

# Maven

Maven is recommended since is exists longer and maybe easier to find answers if we ever run into some problem. Gradle is fine too.

## Maven Loading Archetype List in IntelliJ For Ever

[see this link at stack overflow](http://stackoverflow.com/questions/17421103/create-a-maven-project-in-intellij-idea-12-but-alway-in-the-loading-archetype-l)

- update maven repo: Settings->Maven->Repositories - select maven's Central repo (if it's there; otherwise you should add it (http://repo.maven.apache.org/maven2/)) and press Update button.
- Maven->Importing: "VM options for importer" to -Xmx1024m (default is -Xmx512m and it's not enough). 
