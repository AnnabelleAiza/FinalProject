# Library System(Final Project for data Structure and OOP)
## Auhtor: Annabelle Aizanman 2565007

This project mimics a library system that manages users and items. This system allows users to manage books, DVDs, and 
magazines, including borrowing, returning, searching, sorting, reporting, and storage using CSV files. This project
 demonstrates: inheritance, polymorphism, abstract classes, interfaces, enums, collections, exception handling, Text I/O
(reading and writing), sorting strategies, recursion, lambda expression and stream, etc.

Core classes:

Item(abstract): represents a general item from the library, either book, DVD or magazine. It has fields id, title, and
status. Each subclass must override toCSV(which transforms the item into proper CSV formatting).

User(abstract): represents a library user, either student, teacher or admin. It has fields id, name and a list of 
borrowedItems. Each subclass must override toCSV(which transforms a user into proper csv formatting) and canBorrow(which
tell us if that user can borrow, what they can borrow and how much of them they can borrow).

Library: Main controller class that manages all items and users. Creates a Map<String(id), Item> items as well as 
Map<String(id), user> users. Which are both Maps of users or items that take their id as keys. This class is responsible
for adding users and items, borrowing and returning items, searching, sorting and loading from CSV.

Admin(implements repostable): this class backups users and items to CSV as well as generating a report by item status.
