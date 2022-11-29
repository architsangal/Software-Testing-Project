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

- 