# Welcome to the Quarkus Reactive CRUD Archetype

## Author

<p><b>Name:</b> Luiz Henrique de Sousa Ribas</p>
<p><b>Email:</b> lhs.ribas@gmail.com</p>
<p><b>Linkdin:</b> https://www.linkedin.com/in/lhsribas/</p>

## How to use the Archetype

1. Firstly you need to check out this repo on your machine, using the command git clone
2. Now is necessary to run the maven command to install the archetype into your repository
   
   2.1 Go to the path of the project and execute the command:
   ``` shell script
   $> mvn clean install
   ```
3. After the execution of the procedure above, you can choose the path where your want to generate the project via archetype
   
   3.1 In this case I will create the path:
   ```
   $> cd $HOME/Development/git
   ``` 
   
   3.2 The archetype command generates:
   ```shell script
   $> mvn archetype:generate \
      -DarchetypeGroupId=io.github.lhsribas \
      -DarchetypeArtifactId=quarkus-reactive-crud-archetype \
      -DinteractiveMode=false \
      -DgroupId=com.quarkus.clean_arch.crud \
      -DartifactId=quarkus-reactive-crud
   ```
4. probably now, you have the project in your path with the name *quarkus-reactive-crud*

## ${artifact} Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Before the run

You need to run the following command to give permission to execute script mvnw
```
chmod 0755 mvnw
```

### Execute the Docker Compose to Up the Database example

Access the directory of Docker Compose

```shell script
  cd $path_project/src/main/docker-compose
```

Run the Docker Compose command to Up the container
```shell script
  docker-compose -f postgres.yml up
```

## Running the application in dev mode

You can run your application in dev mode which enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## CRUD Application

This Application is divided into some packages, to provide a pretty understood about 
how to build applications with Clean Architecture concepts.

```shell script
├── app
│   ├── dto
│   │   ├── PaymentRequest.java
│   │   └── PaymentResponse.java
│   ├── rest
│   │   ├── PaymentResource.java
│   │   └── ResourceInterceptor.java
│   └── service
│       ├── PaymentServiceFacade.java
│       └── PaymentService.java
├── cross
│   └── ZonedDateFactory.java
├── domain
│   ├── entity
│   │   └── EPayment.java
│   ├── gateway
│   │   └── IPaymentGateway.java
│   └── usecase
│       ├── IDeletePaymentUseCase.java
│       ├── IFindPaymentUseCase.java
│       ├── impl
│       │   ├── DeletePaymentUseCase.java
│       │   ├── FindPaymentUseCase.java
│       │   ├── SavePaymentUseCase.java
│       │   └── UpdatePaymentUseCase.java
│       ├── ISavePaymentUseCase.java
│       └── IUpdatePaymentUseCase.java
└── infra
    ├── dataprovider
    │   └── PaymentDataProvider.java
    └── db
        ├── model
        │   └── Payment.java
        └── repository
            ├── IPaymentRepository.java
            └── PaymentRepository.java

```
Each Package has its responsibilities, that we explain below:

### app

Contains the source code structure that connects the front-end with the back-end, where the Rest, DTO and Services services are located to connect with the Domain layer;

### cross

Responsible for containing implementations of utilities that can be used in all layers of the architecture;

### domain

Responsible for storing the system's business logic and entity classes. This layer communicates with the infrastructure, passing the data to be stored or sent to a kafka topic for example;

### infra -> DB

Responsible for containing all persistence entities and repositories that communicate with the database, making data storage possible;
