⚽ Football Team Maker & Optimization

A Java-based console application for creating and managing football squads under budget and formation constraints. The system automatically drafts players, prevents duplicate selections, tracks team changes, and supports undo operations.

---
🎯 Project Goal

Build the strongest possible football team while staying within a limited budget and formation requirements.

This project demonstrates the practical use of:

* Object-Oriented Programming (OOP)
* Data Structures
* Algorithms
* Resource Optimization Techniques

---
 ✨ Features

✔ Create multiple football teams

✔ Define custom formations

✔ Automatic player drafting based on rankings

✔ Budget-aware team building

✔ Duplicate player prevention across teams

✔ Player replacement and team management

✔ Undo last action functionality

✔ Sorted player display

---
 🗂️ Data Structures Used

--> HashMap

Used as the player database.

* Stores players using **Player ID** as the key
* Provides fast **O(1)** average lookup

--> Priority Queue (Max Heap)

Used for automatic drafting.

* Organizes players by ranking
* Always selects the highest-ranked available player first

--> ArrayList

Used for team management.

* Stores team rosters
* Stores all created teams
* Dynamic and efficient for traversal

--> Stack

Used for transaction history.

* Records team changes
* Enables the **Undo** feature using the **LIFO (Last In, First Out)** principle

---
 ⚙️ Algorithms Implemented

--> Greedy Algorithm

Used during automatic team drafting.

* Selects the best available player at each step
* Prioritizes higher-ranked players
* Works within budget constraints

--> Linear Search

Used for:

* Player existence checks
* Position counting
* Availability verification

--> TimSort (`Collections.sort()`)

Used for sorting players before display.

* Efficient built-in Java sorting algorithm
* Sorts players by ranking

---
🏗️ Object-Oriented Design

--> Player

Represents a football player with:

* ID
* Name
* Position
* Ranking
* Price

--> Team

Represents a football squad and manages:

* Formation
* Budget
* Player roster
* Transaction history

--> TeamSystem

Acts as the main controller responsible for:

* Team creation
* Drafting logic
* Player management
* Validation and constraints

---
🚀 Technologies Used

* Java
* Collections Framework
* Object-Oriented Programming
* Data Structures & Algorithms

---
📌 Learning Outcomes

Through this project, we explored:

* HashMaps for efficient storage and retrieval
* Priority Queues for ranking-based selection
* Stacks for undo functionality
* ArrayLists for dynamic collections
* Greedy algorithms for optimization problems
* Real-world application of OOP principles

---
👨‍💻 Author
Muhammad Haseeb Zafar
