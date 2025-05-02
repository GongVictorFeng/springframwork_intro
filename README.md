# Spring Framework Introduction
A project for the introduction of the Spring framework. It covers the basic concepts.

To design a small game application, there are 3 iterations. We are comparing three implementation to understand the strength of
framework.

## Loose coupling with Spring Framework

* Design Game Runner to run games:
  * Mario, Super Contra, PacMan etc
* Iteration 1: Tightly Coupled
  * GameRunner class
  * Game classes: Mario, Super Contra, PacMan etc
  * see implementation: https://github.com/GongVictorFeng/springframwork_intro/commit/78a04ec93c9913f6be8ff2f6098ac8720ad346e1
* Iteration 2: Loose Coupling - Interfaces
  * GameRunner class
  * GamingConsole interface
    * Game classes: Mario, Super Contra, PacMan etc
  *see implementation: https://github.com/GongVictorFeng/springframwork_intro/commit/8ab3338189f4eaf7d8aca0a475ccdeec85eb85fe
* Iteration 3: Loose Coupling - Spring Framework
  * GameRunner Bean (@Component)
  * MarioGame Bean (@Component)
  * Inject MarioGame to GameRunner (@Autowired) - Dependency Injection
  * see implementation: https://github.com/GongVictorFeng/springframwork_intro/commit/559c461a250273fc402ad8a8654cdb117c9834b4

## Spring Framework - Questions

### Q1: What's happening in the background?
  * configure the logging level to find more info - go to application.properties
    and enter 'logging.level.org.springframework=debug'
    * Identified candidate component class: file [GameRunner.class]
    * Identified candidate component class: file [MarioGame.class]
    * Creating share instance of singleton bean 'gameRunner'
    * Creating share instance of singleton bean 'marioGame'
    * Autowiring by type from bean name 'gameRunner' via constructor to bean name 'MarioGame'
    
### Q2: Spring Framework - Important terminology
  * @Component: Class managed by Spring framework
  * Dependency: the instance that is need to create other instance - 
    GameRunner needs Game implement
    * Game impl (MarioGame) is a dependency for GameRunner
  * Component Scan: Spring Framework uses to find component classes
    * It scans packages! - @ComponentScan("learn_spring.framework_intro")
  * Dependency Injection: Identify beans, their dependencies and wire them
    together (provides IOC - Inversion of Control: shift control from us to spring)
    * Spring Beans: An object managed by Spring Framework
    * IoC container: The technical component inside the spring framework which manages
      the lifecycle of beans and dependencies.
      * Types: ApplicationContext (complex), BeanFactory(simpler features)
    * Autowiring: Process of wiring in dependencies for a Spring Bean
    * @Primary: is used when there are multiple matching components

### Q3: Does the Spring Framework really add value? 
  * Real World application are much more complex:
    * Multiple Layers (Web, Business, Data etc) Web -> Business -> Data -> Database
    * Each layer is dependent on the layer below it
      * Example: Business Layer class talks to a Data Layer class - data layer class is a dependency of Business layer class
      * There are thousands of such dependencies in every application
  * With Spring Framework:
    * Instead of focusing on objects, their dependencies and wiring 
      * developers can focus on the business logic of the application
    * Spring Framework manages the lifecycle of objects:
      * Mark components using annotations: @Component (and others..)
      * Mark dependencies using @Autowired
      * Allow Spring Framework to do its magic
  * Example: Controller -> BusinessService(sum) -> DataService(data)
    * see implementation:https://github.com/GongVictorFeng/springframwork_intro/commit/3c8f0344166748a5a952e11bd49a8e19cc00b62a

### Q4: How is Spring JAR downloaded? (Maven)
  * What happens if you manually download Spring JAR?
    * Spring JAR needs other JARS - transitive dependencies
      * needs to download all the transitive dependencies jars
    * What if you need to upgrade to a new version
  * Maven: Manage JARs needed by apps (application dependencies)
    * Once you add a dependency on Spring framework, Maven would download spring framework and its dependencies
  * All configuration in pom.xml
    * Maven artifacts: Identified by the group id, an Artifact id
  * Important Features:
    * Defines a simple project setup that follows best practices
    * Enables consistent usage across all projects
    * Manages dependency updates and transitive dependencies
  * Terminology Warning: Spring Dependency vs Maven Dependency:
    * Maven dependency is a jar that application needs
    * Spring dependency is a spring bean

### Dependency Injection Types:
  * Constructor-based: Dependencies are set by creating the Bean using its Constructor (recommendation)
  * Setter-based: Dependencies are set by calling setter methods on beans
  * Filed: No setter or constructor, dependency is injected using reflection

### Spring Modules
  * Spring Framework is divided into modules:
    * Core: IoC Container etc
    * Testing: Mock Objects, Spring MVC Test etc
    * Data Access: Transactions, JDBC, JPA etc
    * Web Servlet: Spring MVC etc
    * Web Reactive: Spring WebFlux etc
    * Integration: JMS etc
  * Each application can choose the  modules they want to make use of
    * They do not need to make use of all things in Spring framework