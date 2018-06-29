# Deeply Java Demo

This simple demo project shows how to use deeply with our Java wrapper in a Java application.

See the straight-forward usage in less then 20 lines of code in Demo.java and ContentListener.java.


## Project setup

### deeply SDK

First things first. After cloning this repo you need to copy your deeply shared library,
the java wrapper shared library and the deeply.jar to the libs directory:

```
cp ~/deeply-java-v0.1.0/*deeply* ~/deeply-java-demo/libs
```

You also need to copy your license.txt to the project root dir.

```
cp ~/license.txt ~/deeply-java-demo/libs
```

### Gradle

The project requires Gralde 4.8 or later to build. You can install it from: https://gradle.org/install/


## Run

### With JetBrains IntelliJ

Open the project with IntelliJ and run the task "application/run".

### From command line

Or directly run it with gradle

```
cd ~/deeply-java-demo/

gradle run
```

