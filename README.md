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
* Iteration 3: Loose Coupling 
  * GameRunner Bean (@Component)
  * MarioGame Bean (@Component)
  * Inject MarioGame to GameRunner (@Autowired) - Dependency Injection
  * see implementation: https://github.com/GongVictorFeng/springframwork_intro/commit/559c461a250273fc402ad8a8654cdb117c9834b4