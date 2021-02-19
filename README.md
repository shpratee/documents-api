# developers-api project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Scaffold the application

You can run your application in dev mode that enables live coding using:
```
mvn io.quarkus:quarkus-maven-plugin:1.7.1.Final:create -DprojectGroupId=com.demo.api.developers -DprojectArtifactId=developers-api  -DclassName=DevelopersResource
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev
```

## Injecting JSON's support

If your endpoints work with JSON format y“ou will need the quarkus-resteasy-jsonb or quarkus-resteasy-jackson extension in your project”
```
./mvnw quarkus:add-extension -Dextensions="quarkus-resteasy-jackson"
```

## Injecting XML's support
```
./mvnw quarkus:add-extension -Dextensions="quarkus-resteasy-jaxb"
```

## Dependency  injection

Add @Inject annotation on the component needs be injected. The component being injected must be annotated with @ApplicationScoped

## Properties configuration
Eclipse MicroProfile Configuration drives the properties configuration for Quarkus

1. The properties can be defined in "application.properties" present in resources folder.
2. Quarkus supports YAML as well for which, an extension will need be added
```
./mvnw quarkus:add-extension -Dextension="config-yaml"
```
In this case the name of the properties file could be application.yaml or application.yml
3. Profiles are supported with '%' prefixed before the profile name. 'dev', 'test' and 'prod' are three built-in profiles. And if not specified one, prod comes as the default context for a property.
You can specify the profile that you would want to use beyond the built-ins by specifying the property mentioned below
```
./mvnw -Dquarkus.profile=staging

%{profile}.config.key=value
%staging.quarkus.http.port=8081
```
4. Properties can be accessed programmatically by injecting org.eclipse.microprofile.config.Config
```
@Inject
Config config;

public String hello(){
    config.getPropertyNames().forEach(
        p -> System.out.println(p));
}
```
5. Config class can be accessed using ConfigProvider.getConfig() also.
6. Properties in the application.properties can be overwritten by System properties using '-D' or environment variables. System Properties have more priority than environment variables.

## Logger Configuration
The default logging configuration can be changed through properties
```
quarkus.log.level=DEBUG
```
Enable storing logs in a file. While in development and working out of the source directory, your logging file will be in 'target' directory
```
quarkus.log.file.enable=true
```
Quarkus by default supports below Logging libraries
``
JDK java.util.logging
JBoss Logging
SLF4J
Apache Commons Logging
``
Configure logging properties per categories. Categories are represented by class location(the package, subpackages, where they are defined)
``
quarkus.log.category."com.demo.api.developers".level=WARNING
``
Centrally logging. Quarkus supports JSON and GELF(Graylog Extended Log Format)-understood by three most centralized log systems
- Graylog (MongoDB, ElasticSearch, Graylog)
- ELK (ElasticSearch, Logstash, Kibana)
- EFK (ElasticSearch, Fluentd, Kibana)
Input plugins will have to be configured on the basis of what you configure the los to be sent to.

Enable respective extensions for each format type. 
```
./mvnw quarkus:add-extension -Dextension="logging-json"
./mvnw quarkus:add-extension -Dextension="logging-gelf"
```
Quarkus supports syslog format by default without requiring to add any extension.
```
quarkus.log.syslog.enable=true
quarkus.log.syslog.endpoint=localhost:5140
quarkus.log.syslog.protocol=udp
quarkus.log.syslog.app-name=quarkus
quarkus.log.syslog.hostname=quarkus-test”
```

## Packaging and creating a runnable jar (JVM mode)
You want to create a runnable JAR file to be distributed/containerized into a machine with a JVM installed.
The application can be packaged using `./mvnw clean package`.

It produces
1. the `developers-api-1.0-SNAPSHOT-runner.jar` file in the `/target` directory
2. location of dependencies
3. Lib folder with application dependencies

If you want to deploy the application, it is important to copy together the executable jar with the 'lib' directory. 

The application is now runnable using `java -jar target/developers-api-1.0-SNAPSHOT-runner.jar`.

Running Quarkus in this way is known as running Quarkus in the `JVM mode`.

## Packaging and creating a über JAR (JVM mode)
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

To create an über-JAR, a JAR that contains your code runnable classes and all required dependencies, you need to configure Quarkus accordingly in the application.properties file by setting quarkus.package.uber-jar to true.
``
quarkus.package.uber-jar=true
``

## Building a native executable
You want to build your Quarkus application as a native executable jar that is ideal for containers and serverless loads.
Quarkus relies upon GraalVM to build a java application as a native executable.

1. Install GraalVM from: https://www.graalvm.org/docs/getting-started-with-graalvm/
2. Set GRAALVM_HOME environment variable to <GraalVM Dir>/Contents/Home
    Example in macOS: export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.2.0/Contents/Home
3. Set PATH to <GraalVM Dir>/Contents/Home/bin
4. Install "native-image" plugin `gu install native-image` - https://www.graalvm.org/docs/getting-started-with-graalvm/#native-images
5. You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/developers-api-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Building a Docker container for JAR file
Use the Dockerfile.jvm file provided to build the container.

When a Quarkus project is generated using any of the methods explained before, two Dockerfiles are created in src/main/docker: 
1. one for generating a Docker container using Quarkus in the JVM mode
2. another one for the native executable

Pre-requisites:
1. You have docker environment configured already, either locally or in any any pre-packaged environment like Minikube, K3d or KinD

Package the build and build a docker image from project's root
```
./mvnw clean package

docker build -f src/main/docker/Dockerfile.jvm -t developers-api:1.0 .

The container can be started by running the following:

docker run -it --rm -p 8080:8080 developers-api:1.0
```

## Building a Docker container for native executable
To generate a container for running a Quarkus native executable, you can use the Dockerfile.native file to build the container.

To build the Docker image, you need to create a native file that can be run in a Docker container. For this reason, don’t use local GraalVM to build the native executable because the result file will be specific to your operating system and will not be able to run inside a container.

To create an executable that will run in a container, use the following command in your terminal:
```
./mvnw clean package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t developers-api-native:1.0 .

The container can be started by running the following:

docker run -it --rm -p 8080:8080 developers-api-native:1.0
```

## Test the running containers
```
docker ps --> running containers

docker exec -it <CONTAINER_ID> curl -i http://localhost:8080/developers/hello

Response:
HTTP/1.1 200 OK
Content-Length: 10
Content-Type: text/plain;charset=UTF-8

Hello All!
```


