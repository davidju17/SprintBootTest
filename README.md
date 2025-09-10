# Spring Boot Library Management System

A full-stack library management system built to practice Spring Boot knowledge. This application features a React frontend with TypeScript, a Spring Boot backend with MySQL database, and includes user authentication and book management capabilities.

## 🚀 Technologies Used

### Backend
- **Spring Boot 2.7.18** - Main framework for building the REST API
- **Java 17** - Programming language
- **Spring Data JPA** - Data persistence and ORM
- **Spring Data REST** - Automatic REST endpoints
- **Hibernate** - ORM framework with MySQL8Dialect
- **MySQL** - Database for storing books, users, and reviews
- **Lombok** - Reducing boilerplate code
- **Maven** - Build tool and dependency management

### Frontend
- **React 19.1.0** - Frontend framework
- **TypeScript 4.9.5** - Type-safe JavaScript
- **React Router DOM 6.30.1** - Client-side routing
- **Auth0 React 2.4.0** - Authentication and user management
- **React Testing Library** - Testing framework
- **CSS3** - Styling

### Database
- **MySQL 8** - Primary database
- **JDBC** - Database connectivity

## 📁 Project Structure

```
SprintBootTest/
├── 01-starter-files/           # Database scripts and initial setup
│   └── Scripts/                # SQL scripts for database initialization
├── 02-backend/                 # Spring Boot application
│   └── springbootlibrary/      # Main backend project
├── 03-frontend/                # React application
│   └── react-library/          # Main frontend project
└── README.md
```

## 🛠️ How to Run the Project

### Prerequisites
- Java 17 or higher
- Node.js (version 16 or higher)
- MySQL 8.0
- Maven 3.6+

### Database Setup
1. Install and start MySQL server
2. Create a database named `reactlibrarydatabase`
3. Create a user with username: `springstudent` and password: `springstudent`
4. Run the SQL scripts in the `01-starter-files/Scripts/` directory in order:
   ```bash
   # Run scripts in this order:
   # 1. React-Springboot-Add-Tables-Script-1.sql
   # 2. React-SpringBoot-Add-Books-Script-2.sql
   # 3. React-SpringBoot-Add-Books-Script-3.sql
   # 4. React-SpringBoot-Add-Books-Script-4.sql
   # 5. React-SpringBoot-Add-Books-Script-5.sql
   ```

### Backend Setup
1. Navigate to the backend directory:
   ```bash
   cd 02-backend/springbootlibrary
   ```

2. Install dependencies and run the application:
   ```bash
   # Using Maven wrapper (recommended)
   ./mvnw spring-boot:run
   
   # Or using Maven directly
   mvn spring-boot:run
   ```

3. The backend will start on `http://localhost:8080`
4. API endpoints will be available at `http://localhost:8080/api`

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd 03-frontend/react-library
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

4. The React application will start on `http://localhost:3000`

## 🌟 Features
- **Book Management**: Browse, search, and view book details
- **User Authentication**: Secure login using Auth0
- **Book Reviews**: Users can read and write book reviews
- **Responsive Design**: Mobile-friendly interface
- **Pagination**: Efficient data loading with pagination
- **Star Rating System**: Visual rating system for books

## 🔮 Future Improvements

### Immediate Enhancements
- [ ] **Advanced Search**: Implement filters by author, category, publication date
- [ ] **User Profiles**: Enhanced user management and profiles
- [ ] **Shopping Cart**: Add cart functionality for book borrowing/purchasing
- [ ] **Payment Integration**: Implement payment processing
- [ ] **Admin Dashboard**: Administrative interface for managing books and users

### Long-term Goals
- [ ] **Kubernetes Deployment**: Deploy the application using Kubernetes
- [ ] **Microservices Architecture**: Break down into smaller, manageable services
- [ ] **Redis Caching**: Implement caching for better performance
- [ ] **Email Notifications**: Send notifications for book returns, new arrivals
- [ ] **Mobile App**: React Native mobile application
- [ ] **GraphQL API**: Alternative to REST API

### DevOps & Infrastructure
- [ ] **Docker Containerization**: Create Docker images for easy deployment
- [ ] **CI/CD Pipeline**: Automated testing and deployment
- [ ] **Monitoring**: Application monitoring and logging
- [ ] **Security Enhancements**: Advanced security features and audit trails

## 📝 API Documentation
The REST API is automatically generated using Spring Data REST and is available at:
- Base URL: `http://localhost:8080/api`
- Explore endpoints at: `http://localhost:8080/api/profile`

## 🤝 Contributing
This is a practice project using Spring Boot and React. Feel free to fork and experiment!

## 📄 License
This project is for educational purposes.

## Auth0 email address
davidju17+auth0-test@gmail.com
D@vidju17