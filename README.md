# ReLoop – Java Fundamentals Application

ReLoop is a console-based resale negotiation application built using Core Java. It simulates a simple marketplace where users can list items, submit price offers, and negotiate through acceptance, rejection, or counteroffers.

Developed as part of a Java Developer Internship task, this project focuses on applying core programming concepts to a practical application.

## Features

- **View Items:** Browse available items and their asking prices.
- **Add Items:** Add new items with validated names and prices.
- **Make Offers:** Select an item and submit a price offer.
- **Review Offers:** Accept, reject, or counter existing offers.
- **Offer Status Tracking:** Track offers as Pending, Accepted, Rejected, or Countered.
- **Input Validation:** Handle invalid choices and incorrect numeric inputs.
- **Exception Handling:** Prevent invalid numeric input from interrupting the application.

## Tech Stack

- Java
- IntelliJ IDEA
- Git and GitHub

## Core Java Concepts

- Classes and Objects
- Constructors and Methods
- Collections using `ArrayList`
- Exception Handling using `try-catch`
- Loops and Conditional Statements
- User Input using `Scanner`
- Input Validation

## Project Structure

```text
ReLoop/
├── src/
│   ├── Main.java
│   ├── Item.java
│   └── Offer.java
└── README.md
```

## How to Run

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Ensure a compatible Java JDK is installed.
4. Run `Main.java`.
5. Follow the console menu to explore the application.

## Learning Outcomes

Through this project, I practised organizing Java code into classes, managing objects using collections, validating user input, handling exceptions, and implementing basic offer negotiation logic.

## Note

This is a console-based application. Items and offers are stored in memory and are not permanently saved between application runs.
