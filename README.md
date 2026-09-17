# 🛢️ LPG Cylinder Management System

A **Java-based LPG Cylinder Management System** developed as part of the ** Programming Coursework**. The project demonstrates core **Object-Oriented Programming (OOP)** concepts including abstraction, inheritance, polymorphism, encapsulation, method overriding, and input validation.

The system manages different types of LPG cylinders and provides a **Java Swing GUI** to make the application user-friendly and easier to operate.

---

## 📌 Project Overview

The system is designed around an abstract `LPGCylinder` class, which represents the common properties and behaviors of LPG cylinders.

The abstract class is extended by different cylinder types, allowing each subclass to provide its own implementation of specific operations such as **final price calculation** and **displaying cylinder information**.

### Class Structure

```text
                    LPGCylinder
                   (Abstract Class)
                         |
             ┌───────────┴───────────┐
             │                       │
      DomesticCylinder       CommercialCylinder
```

This structure allows common cylinder information and functionality to be maintained in the parent class while specialized behavior is implemented in the child classes.

---

## 🧱 Object-Oriented Concepts

### 1. Abstraction

`LPGCylinder` is an **abstract class** that contains common attributes and behaviors shared by different cylinder types.

It also contains abstract methods such as:

```java
calculateFinalPrice()
display()
```

These methods do not contain their implementation in the abstract class. Instead, the child classes are responsible for implementing them according to their requirements.

### 2. Inheritance

`DomesticCylinder` and `CommercialCylinder` inherit common properties and methods from `LPGCylinder`.

This reduces code duplication and creates a clear relationship between the different cylinder types.

### 3. Polymorphism

The system uses polymorphism by allowing different cylinder objects to be handled through the common `LPGCylinder` type while executing their own overridden implementations of methods such as `calculateFinalPrice()` and `display()`.

### 4. Encapsulation

Cylinder attributes are controlled through appropriate access methods such as **getters and setters**, helping protect the object's data and maintain controlled access.

### 5. Method Overriding

The child classes override the abstract methods defined by `LPGCylinder` and provide their own implementations.

---

## 💰 Price Calculation

The system supports calculation of the **final cylinder price** based on the requirements of the particular cylinder type.

Since domestic and commercial cylinders can have different pricing rules, the calculation method is implemented separately in their respective subclasses.

This demonstrates how **polymorphism and method overriding** can be used to provide different behaviors for related objects.

---

## 🖥️ Graphical User Interface

The project includes a **Java Swing GUI** designed to make the system simple and user-friendly.

The GUI provides components for entering cylinder information, selecting cylinder types, performing operations, and displaying results.

### GUI Components

The application makes use of several Swing components, including:

* `JFrame`
* `JPanel`
* `JLabel`
* `JTextField`
* `JButton`
* `JComboBox`
* `JTextArea`
* `JScrollPane`
* Dialog boxes and event handling

The GUI allows users to interact with the system without needing to work directly with the command line.

---

## ⚙️ Main Operations

The system provides functionality for:

* Adding domestic cylinders
* Adding commercial cylinders
* Entering cylinder details
* Calculating the final price
* Displaying cylinder information
* Identifying the cylinder type
* Updating information
* Clearing input fields
* Displaying stored cylinder records
* Validating user input
* Handling invalid input appropriately

---

## ✅ Input Validation

Input validation is included to prevent invalid data from being entered into the system.

The application validates information such as:

* Required fields
* Numeric values
* Valid cylinder information
* Appropriate input formats
* Valid selections from the GUI

Instead of allowing invalid data to cause unexpected behavior, the system provides appropriate feedback to the user.

---

## 📚 Data Management

The system maintains cylinder objects and allows multiple cylinders to be managed within the application.

Using object-oriented data structures makes it possible to store, access, update, and display different cylinder objects efficiently.

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Object-Oriented Programming**
* **JDK**
* **BlueJ / VS Code**

---

## 🎯 Learning Objectives

This project demonstrates practical understanding of:

* Abstract classes
* Abstract methods
* Inheritance
* Polymorphism
* Encapsulation
* Method overriding
* Constructors
* Getters and setters
* Collections
* Input validation
* Exception handling
* Event-driven programming
* Java Swing GUI development

---

## 🚀 Purpose of the Project

The main purpose of the LPG Cylinder Management System is to apply Java OOP principles to a practical management problem while following the requirements of the **Programming Coursework**.

The project combines a structured object-oriented backend with a **Swing-based graphical interface**, demonstrating how Java concepts can be used to create a functional and user-friendly desktop application.

**Abstraction → Inheritance → Polymorphism → Encapsulation → GUI → Complete Java Application 🚀**
