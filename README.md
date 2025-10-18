📚 Library Management System (Java)

A simplified Library Management System implemented in Java to demonstrate key Object-Oriented Programming (OOP) principles — including Encapsulation, Abstraction, Inheritance, Polymorphism, and Aggregation.

The system manages books, members, and the borrowing/returning process, with support for fine calculation strategies and data persistence through file storage.

⸻

 Features:
 
	•	Manage a collection of books (add, search, display)
	•	Manage library members (add, list, subclasses for different types)
	•	Borrow and return books
	•	Automatically calculate fines for overdue books
	•	Save and load data from a file (save.data)
	•	Demonstrates practical OOP implementation

⸻

🧱 Class Overview


Book:

Represents a single book in the library.
Attributes:
	•	isbn, title, author, availableCopies

Key Methods:

	•	isAvailable()
	•	increaseCopies()
	•	decreaseCopies()

⸻

Member (Abstract Class)

Represents a library member.
Attributes:

	•	memberId, name, contact

Key Methods:

	•	canBorrow() — checks borrowing eligibility
	•	getStatus() — returns active/inactive status

Subclasses:

	•	StudentMember — limited borrowing privileges
	•	FacultyMember — extended borrowing privileges

⸻

BorrowedBook

Represents a record of a borrowed book.
Attributes:

	•	Book book
	•	Member member
	•	Date borrowDate
	•	Date dueDate

⸻

FineCalculationStrategy (Interface)

Defines an abstraction for fine calculation strategies.

Implementations:

	•	PerDayFine — calculates fine per overdue day
	•	FixedFine — applies a fixed fine once the due date is passed

Demonstrates Abstraction and Polymorphism — allowing the library to switch between fine strategies easily.

⸻

Library

Acts as the main controller for managing:

	•	Books
	•	Members
	•	Borrowing and returning logic

Key Methods:

	•	addBook(Book book)
	•	addMember(Member member)
	•	borrowBook(String isbn, String memberId, Date borrowDate, Date dueDate)
	•	returnBook(String isbn, String memberId, FineCalculationStrategy strategy, Date returnDate)
	•	displayBooks()
	•	displayMembers()

Demonstrates Aggregation — Library contains collections of Book and Member objects.

⸻

LibraryManagementSystem (Main Class)

The entry point of the system.
Handles:

	•	Loading saved data on startup (loadLibrary())
	•	Demonstrating book borrowing and returning
	•	Saving data on exit (saveLibrary())

Uses Java Serialization for persistent storage.

	•	On startup → loadLibrary() loads data from save.data
	•	On exit → saveLibrary() saves or overwrites data

⸻




