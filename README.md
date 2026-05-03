# ✈️ Airline Booking System (Microservices Architecture)

## 📌 Overview

This project is a **Microservices-based Airline Booking System** built using **Spring Boot, Spring Cloud, and MySQL**.
It demonstrates real-world backend architecture including **API Gateway, Service Discovery, JWT Authentication, and inter-service communication**.

---

## 🏗️ Architecture

```text
Client → API Gateway → Auth Service → (JWT)
                      → Booking Service → Seat Service → Database
                      → Seat Service → Database

Service Registry (Eureka) handles service discovery
```

---

## 🚀 Tech Stack

* **Backend:** Spring Boot
* **Microservices:** Spring Cloud
* **Service Discovery:** Eureka Server
* **API Gateway:** Spring Cloud Gateway
* **Security:** JWT Authentication
* **Database:** MySQL
* **Build Tool:** Maven

---

## 📁 Project Structure

airline-booking-system/
│
├── cloud/
│   ├── api-gateway
│   └── service-registry
│
├── services/
│   ├── auth-service
│   ├── seat-service
│   ├── booking-service
│
└── README.md


## 🔧 Microservices

### 1. 🔐 Auth Service

* Handles user registration & login
* Generates JWT tokens

### 2. 💺 Seat Service

* Manages seat availability
* Updates seat count after booking

### 3. 🎟️ Booking Service

* Books seats for a flight
* Communicates with Seat Service

### 4. 🌐 API Gateway

* Routes requests to services
* Applies JWT authentication filter

### 5. 📡 Eureka Server

* Service discovery and registration

---

## 🔑 Features

* ✅ Microservices architecture
* ✅ JWT-based authentication
* ✅ API Gateway routing
* ✅ Inter-service communication
* ✅ Real-time seat availability update
* ✅ MySQL database integration

---

## ⚙️ Setup Instructions

### 🔥 1. Clone Repository

```bash
git clone https://github.com/your-username/airline-booking-system.git
cd airline-booking-system
```

---

### 🔥 2. Start Services (IMPORTANT ORDER)

```text
1. Service Registry (Eureka)
2. Auth Service
3. Seat Service
4. Booking Service
5. API Gateway
```

---

### 🔥 3. Database Setup (MySQL)

Create databases:

```sql
CREATE DATABASE user_db;
CREATE DATABASE seat_db;
CREATE DATABASE booking_db;
```

---

## 🧪 API Testing Flow

---

### 🔐 1. Register User

```http
POST /api/auth/register
```

```json
{
  "username": "lokesh",
  "password": "123"
}
```

---

### 🔐 2. Login → Get JWT Token

```http
POST /api/auth/login
```

---

### 💺 3. Create Seat

```http
POST /api/seats
```

```json
{
  "flightNumber": "AI101",
  "totalSeats": 100,
  "availableSeats": 100
}
```

---

### 🔍 4. Get Seat Info

```http
GET /api/seats/AI101
```

---

### 🎟️ 5. Book Ticket

```http
POST /api/bookings
Authorization: Bearer <token>
```

```json
{
  "flightNumber": "AI101",
  "seatsBooked": 2
}
```

---

### 🔍 6. Verify Seat Update

```http
GET /api/seats/AI101
```

---

## 📊 Sample Output

```json
{
  "flightNumber": "AI101",
  "availableSeats": 98
}
```

---

## ⚠️ Common Issues

| Issue               | Solution                                       |
| ------------------- | ---------------------------------------------- |
| Port already in use | Kill Java process (`taskkill /F /IM java.exe`) |
| 404 error           | Check Gateway routes                           |
| 503 error           | Ensure service is registered in Eureka         |
| 401 Unauthorized    | Verify JWT token                               |

---

## 🧠 Key Concepts Demonstrated

* Microservices communication
* API Gateway routing
* Service Discovery (Eureka)
* JWT authentication
* Database per service pattern

---

## 💡 Future Enhancements

* Dockerize services
* Add frontend UI
* Implement role-based access
* Add payment service
* Add logging & monitoring (Zipkin)

---

## 👨‍💻 Author

**Lokesh**

---

## ⭐ Final Note

This project demonstrates a **production-style microservices backend** with proper separation of concerns and secure communication.

---
