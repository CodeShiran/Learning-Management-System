# Learning Management System (LMS)

This **Learning Management System (LMS)** is a robust application developed for the **Enterprise Application Development module**. It offers an efficient way to manage students, teachers, courses, marks, and detailed reporting. With user-friendly interfaces and CRUD functionalities, it simplifies educational data management for institutions.

---

## Features

### 1. **Student Management**
   - Add, update, delete, and view student information.
   - Manage student profiles efficiently.

### 2. **Teacher Management**
   - Add, update, delete, and view teacher details.
   - Manage teacher profiles seamlessly.

### 3. **Course Management**
   - Add, update, delete, and view course details.
   - Assign teachers and students to courses.

### 4. **Marks Management**
   - Record, update, and view students' marks for courses.
   - Generate marks-related reports.

### 5. **Reporting**
   - Create and export detailed reports for:
     - Students
     - Teachers
     - Courses
     - Marks
   - Reports are generated using **Jasper Reports** for accuracy and professional presentation.

---

## Technologies Used

- **Java (JDK 23)**: Core programming language for backend development.
- **NetBeans**: Primary IDE for building and testing the application.
- **XAMPP MySQL**: Database for storing and managing application data.
- **Jasper Reports**: Tool for generating professional reports.

---

## Installation and Setup

### Clone the Repository
To get started, clone the repository:

git clone https://github.com/theekify/ead.git


### Set Up the Database

1. **Launch XAMPP** and start the MySQL service.
2. **Import the provided SQL file** (`LMS_Database.sql`) into MySQL using **phpMyAdmin** or any SQL client.
3. **Configure the database connection** in the application code:
   - Update the `Database.connectiondb` method to match your database credentials (host, username, password).

### Run the Application

#### Using NetBeans
1. **Open the project in NetBeans**.
2. **Ensure all dependencies** are correctly installed.
3. **Run the application** using the IDE's run command.



