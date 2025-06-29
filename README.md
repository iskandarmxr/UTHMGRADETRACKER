# 🎓 UTHM GPA/CGPA Tracker

A full-stack web application built with Spring Boot and Thymeleaf that helps UTHM students calculate their **semester GPA**, **updated CGPA**, and determine their **academic standing** (including Dean’s List eligibility).

---

## ✨ Features

✅ Dynamic input of course grades  
✅ Auto GPA and CGPA calculation  
✅ Dean’s List indicator based on level of study  
✅ Add/remove course rows on the fly  
✅ Clean and responsive Bootstrap UI  

---

## 🧠 Use Case

This application allows students to:
- Enter current **total credit hours** and **CGPA**
- Add courses from the current semester (grade + credit hours)
- Instantly see their **estimated semester GPA**, updated **CGPA**, and **standing**

---

## 💻 Tech Stack

| Layer         | Tech                                   |
|---------------|----------------------------------------|
| Backend       | Spring Boot (Web, Thymeleaf, MVC)      |
| Frontend      | Thymeleaf + Bootstrap 5                |
| Script Engine | Vanilla JS                             |
| Build Tool    | Maven                                   |
| Language      | Java 21                                 |

---

## ⚙️ How to Run

### Prerequisites:
- Java 21
- Maven

### Steps:
```bash
git clone https://github.com/your-username/uthm-grade-tracker.git
cd uthm-grade-tracker
mvn spring-boot:run
```
Open http://localhost:8080 in your browser.
