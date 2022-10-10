# Hexad
Hexad technical assessment 

Library backend application built with Java/Spring boot.

**How to set up Project**

1. Ensure [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) is installed on your machine
2. Ensure [maven](https://maven.apache.org/install.html) is installed on your machine
3. Clone project from private [git repo](https://github.com/AtumaKen/Hexad.git) and checkout master branch
4. Open project in any java enabled IDE of you choice. Strongly recommend [Intellij IDEA](https://www.jetbrains.com/idea/download/).
5. If you experience dependency issues, run `mvn dependency:resolve`



**How to run test**

1. Be sure you are in the root directory of the project (~Hexad).
2. Be sure to have maven installed on your machine 
3. Run the command `mvn test` to run all tests.
4. To execute all tests in a test class, run `mvn test -Dtest="{ClassName}"`. For example, `mvn test -Dtest="TheFirstUnitTest"`
5. To execute a single test method `mvn test -Dtest="{ClassName}#{methodName}"`

**How to run service:**

1. Service runs on port 8080. Be sure port is free


###### _from maven_

1. `mvn spring-boot:run`

###### _as jar file_

1. run `mvn install`
2. Navigate to /target 
3. run java -jar hexad_assesment-0.0.1-SNAPSHOT.jar

