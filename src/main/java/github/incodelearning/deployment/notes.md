## Deploying Self-Contained Applications

[Oracle tutorial](https://docs.oracle.com/javase/tutorial/deployment/selfContainedApps/index.html). This is a single installable bundle that contains your application and a copy of the JRE needed. The build can be done with JavaFX Ant Tasks or `javapackager` command.

## Packaging Programs in JAR Files

Java Archive (JAR) file bundles multiple files into a single archive file. Typically a JAR file contains the class files and auxiliary resources.

### Using JAR Files: The Basics

JAR files are packaged with the ZIP file format, which uses lossless data compression. The Java Archive tool, "the Jar tool', is invoked by using the `jar` command.

```bash
# create a JAR file
jar cf jar-file input-file(s)
# include existing manifest file
jar cmf existing-manifest jar-file input-file(s)
# to view contents
jar tf jar-file
# extract contents
jar xf jar-file
# extract specific files
jar xf jar-file archived-file(s)
# run application
java -jar app.jar
``` 
Time of creation is stored in JAR file. It's recommended to use versioning information in the manifest file rather than creation time to control versions of a JAR file.

## Manifest File

### Default Manifest

Default manifest is created at `META-INF/MANIFEST.MF`. A manifest entries take the form of "header:value" pairs. 

## Signing and Verifying JAR Files

## Using JAR-related APIs

## Resources

- [JAR Archive Files Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/jar/index.html)
- [JAR File Specification](https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html)
