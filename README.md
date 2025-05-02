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