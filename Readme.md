Interface-Driven Enrollment System 
---
Author: Caryl Andrea T. Fermin
---

## **Project Overview**
This system is designed to automate student and instructor registration, streamline tuition fee computations with 
integrated scholarship logic, and safeguard data integrity throughout the enrollment process. More than just a CRUD 
application, this project serves as a demonstration of scalable software architecture and automated quality assurance.
---
## **Key Features**
**Student & Instructor Registration:** Comprehensive lifecycle management for university academic records.
**Automated Tuition Engine**: Precise tuition calculation based on course units, course per rate, and student's discounts.
**Section & Course Management:** Efficient assignment of instructors to specialized courses and systematic organization of 
academic sections.
---
## **Advanced Features**
These features ensure the system is "Production-Ready" and resilient:
**Data Integrity:** A validation logic layer that intercepts and rejects duplicate Student IDs to prevent database 
corruption and maintain record accuracy.
**Dynamic Scholarship Integration:** Real-time application of various scholarship discount rates during the enrollment 
phase.
**Smart Capacity Validation:** A proactive guard logic that automatically prevents enrollment once a section reaches its
defined maximum capacity.
---
## **JUNIT: Automated Testing**
This project emphasizes 100% Logic Verification using the JUnit 5 framework. The AAA (Arrange, Act, Assert) pattern was 
strictly followed to ensure a clean and professional test suite:
- Course Management Test
- Data Integrity Test
- Enrollment Service Test
- Instructor Management Test
- Tuition Fee Payment Test

