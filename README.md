# Neighborly 🏘️

**Neighborly** is a full-stack web platform that allows students and local residents in East Lansing to **borrow, lend, or give away items** like tools, electronics, books, and more. Designed for university towns, the platform makes it easy to share resources, reduce waste, and save money.

---

# 🧠 Inspiration
Neighborly was created to help students and community members share resources more effectively, reduce waste, and build local trust-based networks. Think Craigslist, but safer and college-town focused — with the scalability and UX of a modern product.

---

## 🚀 Features

- 🧾 **User Authentication** – JWT-based login and registration  
- 📦 **Item Listings** – Create, update, delete, and browse listings  
- 🔍 **Search & Filtering** – Keyword and category-based search  
- 🗂️ **Image Uploads** – Secure file handling via AWS S3  
- 🧭 **Location-Based Access** – Community-focused design  
- 🐳 **Dockerized** – Full-stack dev environment with Docker Compose  

---

## 🛠 Tech Stack

### Backend
- **Java + Spring Boot** – REST APIs with Spring Data JPA  
- **PostgreSQL** – Relational database with secure schema design  
- **Spring Security** – JWT-based authentication and authorization  
- **AWS EC2 + S3** – Cloud deployment and image storage  
- **Docker** – Containerized services for local and remote deployment  

### Frontend
- **React** – Interactive UI with stateful components  
- **Fetch API** – For communicating with backend endpoints  
- **Tailwind CSS** – Utility-first CSS framework for modern styling  

---

## 📷 Screenshots *(coming soon)*

---

## ⚙️ Running Locally

### Prerequisites
- Java 21  
- Node.js + npm  
- PostgreSQL or Docker  
- AWS credentials (for file uploads)  

### Backend Setup

```bash
cd backend
./mvnw spring-boot:run
```


### Frontend Setup

```bash
cd frontend
npm install
npm run dev
```


