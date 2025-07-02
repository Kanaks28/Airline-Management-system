# ✈️ Airline Management System

A **Java Swing + MySQL** based Airline Management System with features like flight booking, journey details, customer registration, and flight cancellations. This desktop application is ideal for learning Java GUI development and JDBC database integration.

---

## 📌 Features

- 🧑‍💼 Add Customer Details
- 📄 Generate Boarding Pass
- 📅 Book Flights
- 🚫 Cancel Booked Flights
- 🧾 View Journey Details
- 🔐 Login System
- 🏠 Home Dashboard

---

## 🛠️ Technologies Used

| Technology       | Purpose                              |
|------------------|---------------------------------------|
| Java (Swing)     | GUI Application                       |
| MySQL            | Database                              |
| JDBC             | Java-Database Connectivity            |
| jCalendar        | Date Picker in Booking Forms          |
| rs2xml.jar       | Table Display (JTable + ResultSet)    |
| NetBeans IDE     | Development Environment               |

---

## 🖼️ Screenshots
    
    

---

## 🚀 How to Run the Project

### 🧾 Prerequisites

- Java JDK 17+ (project uses JDK 24)
- NetBeans (optional, for editing)
- MySQL Server (e.g., XAMPP, WAMP, or local installation)

### ⚙️ Setup Steps

1. **Clone or Download** the project.
2. Import the MySQL database:
   - Run the provided SQL script (`airline.sql`) to set up the database and tables (if available).
3. **Update Database Connection:**
   - Open `Conn.java` and modify:
     ```java
     String url = "jdbc:mysql://localhost:3306/your_database_name";
     String user = "your_mysql_username";
     String password = "your_mysql_password";
     ```
4. Navigate to the `dist/` folder and run:
   ```bash
   java -jar AirlineManagementSystem.jar

