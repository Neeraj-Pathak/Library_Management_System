# Library Management System

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple)

## Project Overview

The **Library Management System** is a web-based application designed to efficiently manage a library's collection of books. It enables users to view all books, borrow and return them, and provides administrative features such as adding, and deleting book records. The system offers real-time feedback messages to enhance the user experience, such as alerts for duplicate book entries.

## Features

- View all books in a Bootstrap-styled responsive UI.
- Borrow and return books with ease.
- user capabilities: add, borrow, return and delete books.
- Real-time feedback messages and alerts.
- Responsive design compatible with all devices.

## Technologies Used

- Java 17
- Spring Boot 3.0 (Spring MVC, Spring Data JPA)
- Thymeleaf
- Bootstrap 5.3
- MySQL (or your preferred relational database)
- Maven
- Postman

## Setup and Installation

### Prerequisites

- Java JDK 17 or newer
- Maven
- MySQL or other relational database
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running the Application

```bash
# Clone the repo
git clone https://github.com/Neeraj-Pathak/library-management-system.git
cd library-management-system

# Configure your database in src/main/resources/application.properties

# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
````

Access the application at: [http://localhost:8080](http://localhost:8080)

## Screenshots

*Library Management System*
![Create User Page](https://github.com/user-attachments/assets/cb42d591-cbc6-49da-9315-480103f0532e)

*Home Page*
![2](https://github.com/user-attachments/assets/c839ac6c-6a9c-410e-939e-975fd8ffcc4c)

*Add a new book form*
![3](https://github.com/user-attachments/assets/b412ac57-750b-485e-b324-c5d0d3c65ba4)

*View books*
![4](https://github.com/user-attachments/assets/3bb0ccbd-c82b-4975-92d6-c66f60210b7d)

*Borrow book*
![5](https://github.com/user-attachments/assets/bcf77c35-b9d8-416f-81ba-2b13cf687750)

*Delete book*
![6](https://github.com/user-attachments/assets/78babdbc-ebfa-4372-b806-aeca14edab2a)

*Folder Structure*
![7](https://github.com/user-attachments/assets/d2c87f28-77e8-41c4-a480-ddaa426706dd)





## Future Enhancements

* User authentication with roles (Admin, User)
* Advanced book search and filters
* Loan due dates and fines management
* REST API support for external apps

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests. For major changes, open an issue first to discuss.

