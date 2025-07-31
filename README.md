##  Order-Service Microservice (MongoDB Atlas, Dockerized)

This microservice will:

* Accept product orders
* Call Inventory-Service to check stock availability
* Store order data in **MongoDB Atlas**
* Be containerized using Docker (multi-stage)
* Use **Spring Boot + Spring Web + Spring Data MongoDB + Validation + Lombok**

---

## 💡 Constraints

* MongoDB **must be hosted on MongoDB Atlas**
* Your app must **communicate via REST** with Inventory-Service
* You must build and run it using **Docker & Docker Compose**
* No direct DB connections allowed from local machine — only from within container

---

## 🧱 Starter Project Structure

```
org.example.orderservice
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── mapper
├── model
├── repository
└── service
    ├── client
    └── impl
```
