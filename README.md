# Software Testing Project

## Test Code Link
Here is the link to the repository from which our team used the code from - 
[GitHub Link](https://github.com/JackieAnj/PizzaParlour) (https://github.com/JackieAnj/PizzaParlour).

This is a Java Command Line Interface Program that was built using test driven development, implementing various design patterns. It was done for an intro to software engineering course at the University of Toronto.

There are a lot of Object-Oriented Concepts used and a lot of Design Pattern implemented. E.g. Fractor, Builder, etc.

This code is based on the standard Design Pattern, Pizza problem.

## Test Code Description

- Run PizzaParlour.main()

Select one of the provided options by entering 1, 2, 3, 4, 5, or 6. 

-   (1) Create an Order    
-   (2) Update an Order    
-   (3) Delete an Order
-   (4) Submit an Order
-   (5) View Menu
-   (6) Quit App

## Test Case Strategy Used

Our team tried to minimise the test cases to cover the as many prime paths as possible. We also tried to maximise the edge-coverage. The Control Flow Graph for the code is very large. Majority of the loop are while(true), so the test cases in which we skip the loop, are not feasible. The code is quite rich, so there are many triply nested loop too. 

## Open Source Tools
- JUnit
- Eclipse Code Editor (for Maven Project Building)

## Designed Test Cases

Please refer to the screenshots, for the test cases. The test cases focused on prime path coverage and edge coverage. It is practically not possible to write all the test cases to satisfy the above criteria. So we focus on cases that may help us, in identifying the use cases, with some errors and we were able to achieve it. Following the test cases, that the code was not able to pass-

- Even if either a pizza or a drink was add to the order, the order still checkout, and was proceeded to delivery options.
- If the order is cancelled, then too the order was checking out, and was proceeded to delivery options.

## Observations
- Menu was following a strict format. If that was generated for program's input from another program, it is still okay. But there was nearly no error handling.

## Contributions
- Aditya Vardhan: 
	- Drew Control Flow Graphs - Mapping of CFG with nodes in code (50%)
	- Junit Integration (Maven Project Configuration)
	- Wrote Test Cases (50%)
	- Looked for the source Code, 
	- Wrote Test case for Menu Lack of Error Handling
	- Tried to understand Licenced "Understand", for control flow graph generation
	- README and Report  contributions (50%)
    - Fixed Bug: for the source of Menu.txt
- Archit Sangal:
	- Drew Control Flow Graphs - Mapping of CFG with nodes in code (50%)
	- Wrote Test Cases (50%)
	- README and Report  contributions (50%)
	- Modified the code so as to make it testable e.g. prepared CLI user input mocking, parameterizing the file menu input, etc.
    - Resolved Bugs: Updated code so that it can compile in JDK 17, previously it was in JDK 8.
    - Resolved Bug: Resolved OS related outdated dependencies.
    - Created Stub for Uber Module.
    - Discovered a potential Error handling mismanagement in Menu, modified code so it could be RIP (Reachability, Infection, Propagation).
    - Came up witha method to denote large CFG with reusable properties, due to functions and object oriented code, Compressed Notation.