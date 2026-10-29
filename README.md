# PASCUAL-DSA-Java-Sorting-Queue-Capstone
# Customer Service Queue System

## Description

The Customer Service Queue System is a simple Java console-based application designed to manage customers waiting for service. It allows users to issue ticket numbers, view the waiting queue, serve the next customer, check the next customer, search for customer tickets, and sort waiting customers alphabetically by name.

The system follows the **First-In, First-Out (FIFO)** principle, meaning the first customer to join the queue is the first customer to be served.

## Features

- **Get a Ticket** – Register a customer and assign a unique ticket number.
- **View Waiting Queue** – Display all customers currently waiting for service.
- **Serve Next Customer** – Serve and remove the first customer from the waiting queue.
- **View Next Customer** – Display the next customer to be served without removing them from the queue.
- **Search Customer by Ticket** – Search for a customer using their ticket number and check their status.
- **Sort Customers by Name** – Display waiting customers in alphabetical order without changing their actual queue positions.
- **Exit** – Close the application.

## Technologies Used

- Java
- Java Collections Framework
  - `ArrayList`
  - `Queue`
  - `LinkedList`
- `Scanner` for user input
- Terminal or command prompt

## Requirements

- Java Development Kit (JDK) installed
- A terminal or command prompt
- A text editor or Java IDE, such as IntelliJ IDEA

## How to Run

### 1. Save the source code

Save the Java source code as:

`CustomerQueue.java`

### 2. Open the terminal

Navigate to the folder containing `CustomerQueue.java`.

### 3. Compile the program

```bash
javac CustomerQueue.java
```

### 4. Run the program

```bash
java CustomerQueue
```

## How to Use

1. Run the program.
2. Select an option from the main menu by entering its corresponding number.
3. Follow the instructions displayed in the terminal.
4. Continue using the menu until you select **Exit**.

## Sorting Method

The system uses **Bubble/Insert Sort** to arrange waiting customers alphabetically by name. It creates a separate list of ticket numbers for sorting, so the original waiting queue remains unchanged.

Sorting only changes the order in which customers are displayed in the sorted results. It does not change the order in which customers will be served.

## Queue Management

The program uses a queue to manage waiting customers. The `poll()` method removes the next customer when they are served, while the `peek()` method checks the next customer without removing them.

Customer ticket numbers and names are stored in separate `ArrayList` collections to support customer searches and record retrieval.

## Limitations

- Customer records are stored in memory and are lost when the program closes.
- The system operates through the terminal only.
- The application supports basic queue management and does not include a database or graphical user interface.

## Project Purpose

This project demonstrates basic Java programming concepts, including variables, conditional statements, loops, methods, exception handling, collections, searching, sorting, and queue operations.

## System's Screenshots
**Menu** <img width="297" height="248" alt="image" src="https://github.com/user-attachments/assets/6b3bcf75-e5ef-4d93-bf3a-883084143e55" />

**Creating Ticket** <img width="357" height="187" alt="image" src="https://github.com/user-attachments/assets/4b8bdc2f-5a1f-40f7-84d1-45fc422dc442" />

**View of Waiting Queue** <img width="402" height="180" alt="image" src="https://github.com/user-attachments/assets/4ef40502-157c-433c-8740-52b6946f575c" />

**Serve Next Customer** <img width="367" height="137" alt="image" src="https://github.com/user-attachments/assets/581aff67-e64c-491d-b181-ed85792ca785" />

**View Next Customer** <img width="305" height="98" alt="image" src="https://github.com/user-attachments/assets/66b49f9b-736e-4f6c-bef6-adb260077399" />

**Bubble Sort(Oldest First)** <img width="363" height="202" alt="image" src="https://github.com/user-attachments/assets/ada2acf8-e5f6-4abf-9f4e-2669c8e58ea0" />

**Insert Sort(New First)** <img width="281" height="153" alt="image" src="https://github.com/user-attachments/assets/6c51d920-9003-43af-b026-5b7a5da4b3a2" />



