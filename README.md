Project Overview
The Football Team Maker is a Java-based console application that allows users to create and manage football squads under budget and formation constraints. The system maintains player records, automates drafting, prevents duplicate player selection, and tracks team transactions.
Purpose of the Project
The project demonstrates the practical application of Data Structures, Algorithms, and Object-Oriented Programming concepts. It uses specialized data structures to improve efficiency while managing team creation, player selection, and transaction history.
Importance of Solving the Problem
The project addresses a resource optimization problem where limited budgets must be used to build the strongest possible team. Similar challenges exist in real-world systems such as resource allocation, scheduling, and inventory management. The project highlights how efficient algorithms and data structures can improve performance and reliability.
Problem Statement
To develop a Java application that efficiently creates and manages football teams within budget and formation constraints using appropriate data structures and algorithms
.Data Structures Used
HashMap
•	Stores all player records using Player ID as the key.
•	Provides fast O(1) lookup for player retrieval.
Priority Queue (Max-Heap)
•	Manages players based on ranking.
•	Enables efficient selection of the highest-ranked available player.
ArrayList
•	Stores team rosters and the list of created teams.
•	Allows dynamic resizing and easy access to elements.
Stack
•	Maintains transaction history.
•	Supports the Undo feature using the LIFO principle.
Algorithms Implemented
Greedy Algorithm
•	Used during automatic team drafting.
•	Selects the best available player while respecting budget limits.
Linear Search
•	Used for checking player existence, counting positions, and verifying availability.
TimSort (Collections.sort)
•	Used for sorting player lists by rank before displaying them to users.
