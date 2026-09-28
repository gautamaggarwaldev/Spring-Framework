\# Spring Framework Learning Repository



A hands-on Java repository covering Spring Framework and Spring Boot concepts through a progressive collection of independent lesson projects, ranging from Spring Core and dependency injection to REST APIs, JPA/Hibernate, transactions, Spring Security, OAuth 2.0/OIDC, JWT authentication, and testing.



\---



\## 📌 Overview



This repository contains practical implementations created while learning the Spring ecosystem.



Rather than being a single application, the repository is organized into numbered `Lec\_\*` directories. Most lessons are standalone Maven projects that demonstrate a particular Spring concept or backend development technique.



The learning progression includes:



\* Spring Core and dependency injection

\* Bean lifecycle and XML configuration

\* Spring Boot fundamentals

\* REST APIs and CRUD operations

\* DTOs and validation

\* Exception handling

\* Profiles, filters, and interceptors

\* Aspect-Oriented Programming (AOP)

\* JDBC and Spring JDBC

\* Hibernate and JPA

\* JPA entity relationships

\* Spring Data JPA

\* Transactions

\* Spring Security

\* Database-backed authentication

\* Password encoding

\* JWT-based resource-server security

\* OAuth 2.0 / OpenID Connect login

\* Spring MVC and service-layer testing with Mockito



The repository is primarily intended as a \*\*learning and reference codebase for Java/Spring backend development\*\*.



\---



\## ✨ Features \& Topics Covered



\### Spring Core



\* Spring application context

\* Core dependency injection concepts

\* Bean configuration

\* Bean lifecycle

\* XML-based Spring configuration



\### Spring Boot



\* Spring Boot application setup

\* Maven-based Spring Boot projects

\* REST controllers

\* Request mapping

\* Dependency injection

\* Configuration through `application.properties`



\### REST APIs



The repository contains multiple REST API implementations, including CRUD-style student and product APIs.



Examples include:



\* Creating resources

\* Reading individual resources

\* Reading collections

\* Updating resources

\* Deleting resources

\* Soft deletion

\* Request/response DTOs

\* Request validation



\### Data Access



The repository demonstrates several approaches to persistence:



\* JDBC

\* Spring JDBC

\* Hibernate

\* JPA

\* Spring Data JPA

\* MySQL

\* SQL Server JDBC support in one CRUD lesson

\* JPA entity relationships

\* Transaction management



\### API Design



Several lessons demonstrate progressively more structured API implementations using:



\* Controllers

\* Services

\* Repositories

\* Entities

\* DTOs

\* Validation

\* Exception handling



\### Security



Security-related lessons cover:



\* Spring Security

\* Basic authentication configuration

\* Database-backed user authentication

\* BCrypt password encoding

\* Stateless security

\* JWT generation and validation

\* OAuth 2.0 client login

\* OpenID Connect

\* Custom OIDC user processing



\### AOP



The repository contains multiple AOP lessons exploring Spring's aspect-oriented programming support and AspectJ integration.



\### Testing



The testing lesson includes:



\* JUnit 5

\* Mockito

\* `MockMvc`

\* `@WebMvcTest`

\* Service-layer unit tests

\* Controller-layer tests

\* Mocked dependencies

\* Interaction verification



\---



\## 🛠️ Tech Stack



| Category              | Technologies                                |

| --------------------- | ------------------------------------------- |

| Language              | Java                                        |

| Build Tool            | Maven                                       |

| Spring                | Spring Framework                            |

| Spring Boot           | Spring Boot 4.x                             |

| Web                   | Spring MVC / WebMVC                         |

| Persistence           | JPA, Hibernate, Spring Data JPA             |

| Database              | MySQL                                       |

| Database Connectivity | JDBC, MySQL Connector/J, SQL Server JDBC    |

| Security              | Spring Security                             |

| Authentication        | Database authentication, JWT                |

| OAuth                 | Spring Security OAuth 2 Client, OIDC        |

| AOP                   | Spring AOP / AspectJ support                |

| Validation            | Spring Boot Validation / Jakarta Validation |

| Testing               | JUnit 5, Mockito, Spring MVC Test           |

| Code Generation       | Lombok in selected projects                 |



The newer Spring Boot lesson projects specify Java 25 in their Maven configuration. Earlier standalone Maven projects in the repository use Java 17, while one early Spring Boot project specifies Java 21. Therefore, the repository as a whole does \*\*not\*\* have one universal Java version.



\---



\## 🏗️ Architecture



This repository does not represent one single application architecture. Each lesson is generally an independent example.



The later REST/JPA lessons commonly follow a layered structure similar to:



```mermaid

flowchart TD

&#x20;   Client --> Controller

&#x20;   Controller --> Service

&#x20;   Service --> Repository

&#x20;   Repository --> Database

```



For the CRUD and JPA examples, the repository contains controller, service, entity and persistence layers. For example, the soft-delete lesson exposes a `StudentController`, delegates operations to `StudentService`, and persists `Student` entities.



The security lessons add an authentication/authorization layer:



```mermaid

flowchart TD

&#x20;   Client --> Security

&#x20;   Security --> Controller

&#x20;   Controller --> Service

&#x20;   Service --> Repository

&#x20;   Repository --> Database

```



The JWT security lesson configures stateless security, authenticates users through a `DaoAuthenticationProvider`, and configures JWT encoding/decoding for the resource server.



The OAuth lesson uses an external OpenID Connect provider:



```mermaid

flowchart TD

&#x20;   User --> SpringApplication

&#x20;   SpringApplication --> OAuthProvider

&#x20;   OAuthProvider --> CustomOidcUserService

&#x20;   CustomOidcUserService --> UserService

&#x20;   UserService --> Database

```



The OAuth example configures OAuth 2.0 login and processes the authenticated OIDC user through a custom `CustomOidcUserService`.



\---



\## 📂 Project Structure



The repository is organized chronologically by lesson:



```text

Spring-Framework/

├── Lec\_1/

│   └── demo/

├── Lec\_2/

│   └── demo/

├── Lec\_3/

│   └── coredemo/

├── Lec\_4/

├── Lec\_5/

├── Lec\_6/

│   └── bean\_lifecycle\_demo/

├── Lec\_7/

│   └── xml\_config\_demo/

├── Lec\_8/

├── Lec\_9/

│   └── DemoApplication/

├── Lec\_10/

│   └── CRUDSpringBootDemo/

├── Lec\_11/

│   └── crudSpringBootDemoSQL/

├── Lec\_12/

│   └── springBootCRUDWithSoftDelete/

├── Lec\_13/

│   └── servletCrudDemo/

├── Lec\_14/

├── Lec\_15/

│   └── CrudDTODemo/

├── Lec\_16/

│   └── DtoExceptionHandlingDemo/

├── Lec\_17/

│   └── profileDemo/

├── Lec\_18/

│   └── filterDemo/

├── Lec\_19/

│   └── filterDemoTwo/

├── Lec\_20/

│   └── interceptorsDemo/

├── Lec\_21/

│   └── AOPDemo/

├── Lec\_22/

│   └── AOPDemoTwo/

├── Lec\_23/

│   └── AOPDemoThree/

├── Lec\_24/

│   └── AOPDemoFour/

├── Lec\_25/

│   └── JDBCdemo/

├── Lec\_26/

│   └── springJDBCdemo/

├── Lec\_27/

│   └── HibernateDemo/

├── Lec\_28/

│   └── HibernateInternalsDemo/

├── Lec\_29/

│   └── JPARelationships/

├── Lec\_30/

│   └── JpaRelationshipDemo/

├── Lec\_31/

│   └── SpringDataJPAdemo/

├── Lec\_32/

│   └── TransactionDemo/

├── Lec\_33/

│   └── TransactionalDemo/

├── Lec\_34/

│   └── SpringSecurityDemo/

├── Lec\_35/

│   └── SpringSecurityDBAuthAndPasswordSecurity/

├── Lec\_36/

│   └── SpringSecurityDBAuthAndPasswordSecurity/

├── Lec\_37/

│   └── SpringSecurityDBAuthAndPasswordSecurity/

├── Lec\_38/

│   └── OAuthDemo/

├── Lec\_39/

│   └── SpringTestingDemo/

├── .classpath

├── .gitignore

├── .project

└── .vscode/

```



\### Important Directories



| Directory                   | Focus                                                |

| --------------------------- | ---------------------------------------------------- |

| `Lec\_1` – `Lec\_8`           | Early Spring/Java/Maven learning examples            |

| `Lec\_6/bean\_lifecycle\_demo` | Spring bean lifecycle                                |

| `Lec\_7/xml\_config\_demo`     | XML-based Spring configuration                       |

| `Lec\_9/DemoApplication`     | Spring Boot web application                          |

| `Lec\_10` – `Lec\_16`         | REST, CRUD, DTOs, validation and exception handling  |

| `Lec\_17`                    | Spring profiles                                      |

| `Lec\_18` – `Lec\_20`         | Filters and interceptors                             |

| `Lec\_21` – `Lec\_24`         | AOP examples                                         |

| `Lec\_25` – `Lec\_33`         | JDBC, Hibernate, JPA, relationships and transactions |

| `Lec\_34` – `Lec\_37`         | Spring Security and authentication                   |

| `Lec\_38`                    | OAuth 2.0 / OIDC                                     |

| `Lec\_39`                    | Spring testing                                       |



\---



\## 📚 Lesson Roadmap



| Lesson | Project                                   | Main Topic                                        |

| -----: | ----------------------------------------- | ------------------------------------------------- |

|      1 | `demo`                                    | Early Spring Boot/Maven example                   |

|      2 | `demo`                                    | Java persistence/database-related experimentation |

|      3 | `coredemo`                                | Spring Core                                       |

|      4 | —                                         | Lesson workspace                                  |

|      5 | —                                         | Lesson workspace                                  |

|      6 | `bean\_lifecycle\_demo`                     | Bean lifecycle                                    |

|      7 | `xml\_config\_demo`                         | XML configuration                                 |

|      8 | —                                         | Lesson workspace                                  |

|      9 | `DemoApplication`                         | Spring Boot Web MVC                               |

|     10 | `CRUDSpringBootDemo`                      | CRUD with Spring Boot/JPA                         |

|     11 | `crudSpringBootDemoSQL`                   | CRUD with SQL database configuration              |

|     12 | `springBootCRUDWithSoftDelete`            | CRUD + soft delete                                |

|     13 | `servletCrudDemo`                         | Servlet-based CRUD                                |

|     14 | —                                         | Lesson workspace                                  |

|     15 | `CrudDTODemo`                             | DTO-based CRUD + validation                       |

|     16 | `DtoExceptionHandlingDemo`                | DTOs + exception handling                         |

|     17 | `profileDemo`                             | Spring profiles                                   |

|     18 | `filterDemo`                              | Servlet filters                                   |

|     19 | `filterDemoTwo`                           | Filter example                                    |

|     20 | `interceptorsDemo`                        | Spring MVC interceptors                           |

|     21 | `AOPDemo`                                 | AOP                                               |

|     22 | `AOPDemoTwo`                              | AOP / AspectJ                                     |

|     23 | `AOPDemoThree`                            | AOP / AspectJ                                     |

|     24 | `AOPDemoFour`                             | AOP                                               |

|     25 | `JDBCdemo`                                | JDBC                                              |

|     26 | `springJDBCdemo`                          | Spring JDBC                                       |

|     27 | `HibernateDemo`                           | Hibernate/JPA                                     |

|     28 | `HibernateInternalsDemo`                  | Hibernate internals                               |

|     29 | `JPARelationships`                        | JPA relationships                                 |

|     30 | `JpaRelationshipDemo`                     | JPA relationship example                          |

|     31 | `SpringDataJPAdemo`                       | Spring Data JPA                                   |

|     32 | `TransactionDemo`                         | Transactions                                      |

|     33 | `TransactionalDemo`                       | `@Transactional`                                  |

|     34 | `SpringSecurityDemo`                      | Spring Security                                   |

|     35 | `SpringSecurityDBAuthAndPasswordSecurity` | Database authentication                           |

|     36 | `SpringSecurityDBAuthAndPasswordSecurity` | Security progression                              |

|     37 | `SpringSecurityDBAuthAndPasswordSecurity` | JWT/resource-server security                      |

|     38 | `OAuthDemo`                               | OAuth 2.0 / OIDC                                  |

|     39 | `SpringTestingDemo`                       | JUnit, Mockito and MockMvc                        |



\---



\## 🚀 Getting Started



Because the repository contains multiple independent Maven projects, you should run a specific lesson rather than attempting to start the repository root as one application.



\### Prerequisites



Depending on the lesson you want to run:



\* Java

\* Maven

\* MySQL for database-backed lessons

\* A Google OAuth application for the OAuth lesson

\* An IDE such as IntelliJ IDEA, Eclipse or VS Code is optional



\### Java Versions



The repository contains projects using different Java versions.



Examples:



\* Some early projects use Java 17.

\* One early Spring Boot project uses Java 21.

\* The later Spring Boot projects generally specify Java 25.



Always check the selected lesson's `pom.xml` before running it.



\---



\## 📥 Installation



Clone the repository:



```bash

git clone https://github.com/gautamaggarwaldev/Spring-Framework.git

cd Spring-Framework

```



Choose a lesson:



```bash

cd Lec\_39/SpringTestingDemo

```



Build it with Maven:



```bash

mvn clean install

```



Or run tests:



```bash

mvn test

```



For Spring Boot applications that include the Spring Boot Maven plugin:



```bash

mvn spring-boot:run

```



The exact command depends on the selected lesson and its Maven configuration.



\---



\## ⚙️ Configuration \& Environment Variables



Several projects use `application.properties`.



\### Database Configuration



Database-backed lessons configure properties similar to:



```properties

spring.datasource.url=jdbc:mysql://localhost:3306/<database>

spring.datasource.username=<username>

spring.datasource.password=<password>



spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format\_sql=true

```



Create the required database before starting a database-backed lesson.



\### OAuth Configuration



The OAuth lesson expects Google OAuth client credentials:



```properties

spring.security.oauth2.client.registration.google.client-id=${CLIENT\_ID}

spring.security.oauth2.client.registration.google.client-secret=${CLIENT\_SECRET}

spring.security.oauth2.client.registration.google.scope=openid,profile,email

```



Set these values through your environment/configuration rather than committing credentials to Git.



Example:



```bash

export CLIENT\_ID="your-client-id"

export CLIENT\_SECRET="your-client-secret"

```



On Windows PowerShell:



```powershell

$env:CLIENT\_ID="your-client-id"

$env:CLIENT\_SECRET="your-client-secret"

```



\### JWT Configuration



The JWT security lesson uses properties for:



```properties

jwt.secret=<your-base64-secret>

jwt.issuer=<your-issuer>

jwt.expiry=<expiry-in-seconds>

```



Use a newly generated secret for your own environment.



\### ⚠️ Security Notice



Some existing lesson configuration files contain hard-coded local database credentials and security secrets.



Before:



\* publishing the repository publicly,

\* deploying an application,

\* sharing the repository with others, or

\* reusing the examples in production,



replace those values with environment variables or another secure configuration mechanism and rotate any credentials/secrets that have already been exposed.



\---



\## ▶️ Running Individual Lessons



\### Spring Boot Example



For a Spring Boot lesson:



```bash

cd Lec\_9/DemoApplication

mvn spring-boot:run

```



\### CRUD Example



```bash

cd Lec\_12/springBootCRUDWithSoftDelete

mvn spring-boot:run

```



Make sure the required database configuration is available before starting database-backed examples.



\### Security Example



```bash

cd Lec\_34/SpringSecurityDemo

mvn spring-boot:run

```



\### OAuth Example



```bash

cd Lec\_38/OAuthDemo

mvn spring-boot:run

```



Configure the OAuth client credentials first.



\### Testing Example



```bash

cd Lec\_39/SpringTestingDemo

mvn test

```



\---



\# 🔌 API Documentation



The repository contains several independent REST APIs. The endpoints below are examples from the implemented controllers and are \*\*lesson-specific\*\*, not a single unified API.



\## Student CRUD — `Lec\_12`



Base path:



```text

/api/students

```



| Method   | Endpoint                            | Description           |

| -------- | ----------------------------------- | --------------------- |

| `POST`   | `/api/students/create`              | Create a student      |

| `GET`    | `/api/students/get?id={id}`         | Get one student       |

| `GET`    | `/api/students/getAll`              | Get all students      |

| `PUT`    | `/api/students/update?id={id}`      | Update a student      |

| `DELETE` | `/api/students/delete?id={id}`      | Delete a student      |

| `PATCH`  | `/api/students/delete-soft?id={id}` | Soft-delete a student |



The soft-delete implementation stores a `deleted` flag on the `Student` entity.



\---



\## Student CRUD with DTOs — `Lec\_15`



Base path:



```text

/api/students

```



| Method   | Endpoint                            | Description                          |

| -------- | ----------------------------------- | ------------------------------------ |

| `POST`   | `/api/students/create`              | Create a student using a request DTO |

| `GET`    | `/api/students/get?id={id}`         | Get a student                        |

| `GET`    | `/api/students/getAll`              | Get all students                     |

| `PUT`    | `/api/students/update?id={id}`      | Update a student                     |

| `DELETE` | `/api/students/delete?id={id}`      | Delete a student                     |

| `PATCH`  | `/api/students/delete-soft?id={id}` | Soft-delete a student                |



The create endpoint uses Jakarta validation through `@Valid` and separates request/response DTOs from the entity model.



\---



\## Student CRUD with Exception Handling — `Lec\_16`



Base path:



```text

/api/students

```



| Method   | Endpoint                            | Description           |

| -------- | ----------------------------------- | --------------------- |

| `POST`   | `/api/students`                     | Create a student      |

| `GET`    | `/api/students/{id}`                | Get a student         |

| `GET`    | `/api/students`                     | Get all students      |

| `PUT`    | `/api/students?id={id}`             | Update a student      |

| `DELETE` | `/api/students?id={id}`             | Delete a student      |

| `PATCH`  | `/api/students/delete-soft?id={id}` | Soft-delete a student |



This version continues the DTO-based design and adds exception-handling concepts around the API layer.



\---



\## Product API — `Lec\_39`



Base path:



```text

/api/products

```



| Method | Endpoint             | Description        |

| ------ | -------------------- | ------------------ |

| `GET`  | `/api/products/{id}` | Retrieve a product |

| `POST` | `/api/products`      | Create a product   |



The controller delegates product operations to `ProductService`.



\---



\## Authentication API — `Lec\_37`



\### Login



```http

POST /auth/login

```



The login endpoint accepts a username/password request, authenticates it through Spring Security's `AuthenticationManager`, and returns a JWT.



\### User Registration



```http

POST /api/users/register

```



\### Authenticated User Test



```http

GET /api/users/hello

```



The security configuration permits registration and login while requiring authentication for other requests.



\---



\# 🗄️ Database



Database-backed lessons primarily use \*\*MySQL\*\*.



Examples include:



\* CRUD applications

\* Hibernate examples

\* JPA relationship examples

\* Spring Data JPA

\* Transaction examples

\* Database-backed Spring Security

\* OAuth user persistence



Several Maven projects include the MySQL Connector/J dependency.



\## Example Database Configuration



```properties

spring.datasource.url=jdbc:mysql://localhost:3306/<database>

spring.datasource.username=<username>

spring.datasource.password=<password>

```



Some lessons also configure Hibernate to update the schema automatically:



```properties

spring.jpa.hibernate.ddl-auto=update

```



The repository does not contain one universal database schema because each lesson is an independent example.



\---



\# 🔐 Authentication \& Authorization



The security lessons progressively demonstrate different Spring Security approaches.



\## Basic Spring Security



`Lec\_34/SpringSecurityDemo` uses:



```text

spring-boot-starter-security

spring-boot-starter-webmvc

```



Its configuration includes an application-level username, password and roles through Spring Boot properties.



\---



\## Database Authentication



The database-security lessons combine:



\* Spring Security

\* Spring Data JPA

\* MySQL

\* Custom user details

\* Password encoding



The repository includes a `DaoAuthenticationProvider` configured with a custom `CustomUserDetailsService` and BCrypt password encoding.



\---



\## JWT Security



The later security lesson configures:



\* Stateless sessions

\* `DaoAuthenticationProvider`

\* BCrypt

\* JWT encoder

\* JWT decoder

\* HS256

\* JWT authority extraction

\* Spring Security OAuth2 Resource Server



The JWT issuer and secret are supplied through application properties.



\---



\## OAuth 2.0 / OpenID Connect



`Lec\_38/OAuthDemo` uses:



```text

spring-boot-starter-security-oauth2-client

```



The application configures Google OAuth/OIDC login with:



```text

openid

profile

email

```



After successful authentication, the application redirects to `/profile`. A custom OIDC user service processes the authenticated user and delegates registration/update behavior to `UserService`.



\---



\# 🤖 AI/ML Features



No AI/ML functionality was identified in the repository.



This README therefore does not claim integration with OpenAI, Gemini, LangChain, machine-learning models, or other AI services.



\---



\# 🧪 Testing



The repository includes testing support in several Spring Boot projects, with a dedicated testing project in `Lec\_39/SpringTestingDemo`.



The testing project uses:



\* JUnit 5

\* Mockito

\* Spring MVC Test

\* `MockMvc`

\* `@WebMvcTest`

\* `@MockitoBean`

\* Mockito verification

\* Service-layer unit tests



The controller tests verify HTTP status codes, JSON response content and service interactions.



The service tests mock the repository and verify both successful and exceptional cases, including duplicate product-name handling.



Run the tests from the selected Maven project:



```bash

mvn test

```



For example:



```bash

cd Lec\_39/SpringTestingDemo

mvn test

```



\---



\# 🐳 Docker



No Dockerfile or Docker Compose configuration was identified at the repository root.



Docker is therefore not documented as a supported execution method for this repository.



\---



\# 🚀 Deployment



The repository is structured primarily as a collection of local learning projects.



No verified deployment configuration or deployment platform configuration is included at the repository root.



Deployment instructions are therefore intentionally omitted rather than assuming a platform such as Render, Railway, AWS, Azure, or Vercel.



\---



\# 📋 Maven Commands



Each Maven lesson is an independent project.



Run commands from the directory containing the relevant `pom.xml`.



\### Compile



```bash

mvn compile

```



\### Run tests



```bash

mvn test

```



\### Clean and build



```bash

mvn clean install

```



\### Run a Spring Boot application



```bash

mvn spring-boot:run

```



\### Package



```bash

mvn package

```



Not every lesson is a Spring Boot web application, so `mvn spring-boot:run` should only be used for lessons that contain the Spring Boot Maven plugin/application setup.



\---



\# 🧭 Recommended Learning Order



The repository naturally forms a progression:



```text

Spring Core

&#x20;   ↓

Dependency Injection \& Beans

&#x20;   ↓

Bean Lifecycle

&#x20;   ↓

XML Configuration

&#x20;   ↓

Spring Boot

&#x20;   ↓

REST APIs

&#x20;   ↓

CRUD

&#x20;   ↓

DTOs \& Validation

&#x20;   ↓

Exception Handling

&#x20;   ↓

Filters \& Interceptors

&#x20;   ↓

AOP

&#x20;   ↓

JDBC

&#x20;   ↓

Spring JDBC

&#x20;   ↓

Hibernate

&#x20;   ↓

JPA

&#x20;   ↓

JPA Relationships

&#x20;   ↓

Spring Data JPA

&#x20;   ↓

Transactions

&#x20;   ↓

Spring Security

&#x20;   ↓

Database Authentication

&#x20;   ↓

JWT

&#x20;   ↓

OAuth 2.0 / OIDC

&#x20;   ↓

Testing

```



This ordering reflects the progression represented by the numbered lesson directories rather than treating the repository as one application.



\---



\# 🔮 Future Improvements



The following are suggestions for improving the repository itself; they are \*\*not currently implemented features\*\*.



\* Add a root-level learning roadmap linking every lesson directly to its directory.

\* Add a short README inside each major lesson project.

\* Standardize Java versions where practical.

\* Externalize all database credentials and security secrets.

\* Add `.env.example` or documented configuration templates where appropriate.

\* Remove or rotate credentials/secrets that have already been committed.

\* Add automated tests to lessons that currently do not contain them.

\* Add API examples using curl or Postman where REST endpoints are available.

\* Add database setup scripts for database-dependent lessons.

\* Add GitHub Actions for automated Maven builds and tests.

\* Add a root-level contribution guide for the learning repository.

\* Add screenshots only for lessons where a visual demonstration provides meaningful value.



\---



\# 🤝 Contributing



Contributions are welcome if they improve the learning value or code quality of the repository.



A typical workflow:



1\. Fork the repository.

2\. Create a feature branch.



```bash

git checkout -b feature/your-feature

```



3\. Make your changes.

4\. Run the relevant Maven tests.



```bash

mvn test

```



5\. Commit your changes.



```bash

git add .

git commit -m "Add your change"

```



6\. Push the branch.



```bash

git push origin feature/your-feature

```



7\. Open a pull request.



When contributing, keep individual lessons independent and avoid introducing dependencies that are unrelated to the lesson being demonstrated.



\---



\# 🔒 Security Notes



Do not commit:



\* Database passwords

\* OAuth client secrets

\* JWT signing secrets

\* API keys

\* Production credentials



The repository currently contains configuration values that should be treated as sensitive. Before using these examples outside a local learning environment, move secrets into environment variables or another secure secret-management mechanism and rotate credentials that have already been exposed.



For example:



```properties

spring.datasource.username=${DB\_USERNAME}

spring.datasource.password=${DB\_PASSWORD}



spring.security.oauth2.client.registration.google.client-id=${CLIENT\_ID}

spring.security.oauth2.client.registration.google.client-secret=${CLIENT\_SECRET}



jwt.secret=${JWT\_SECRET}

```



\---



\# 📄 License



No license has currently been specified for this repository.



\---



\# 👨‍💻 Author



\*\*Gautam Aggarwal\*\*



GitHub: \[@gautamaggarwaldev](https://github.com/gautamaggarwaldev)



\---



\## 📌 Repository



\[Spring-Framework](https://github.com/gautamaggarwaldev/Spring-Framework)



A practical collection of Spring Framework and Spring Boot lessons progressing from fundamentals to REST APIs, persistence, security, OAuth/OIDC and automated testing.



