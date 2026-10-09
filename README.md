# Adaptive AI Learning Platform

An AI-powered learning platform built with **Java, Spring Boot, MongoDB, and Google's Gemini API**. The goal is to personalize learning by generating educational content, evaluating quiz performance, identifying weak topics, and recommending lessons based on learner progress.

> **Project status:** Backend development in progress.

## Overview

Traditional learning platforms often provide the same learning path to every learner. This project aims to make learning more personalized by analyzing quiz results and progress, then recommending lessons that help learners improve their weak areas.

## Features Implemented

- **Course Management:** Create and manage courses.
- **Module and Lesson Management:** Organize courses into modules and lessons.
- **AI Integration:** Integrate Google's Gemini API for AI-powered functionality.
- **Quiz System:** Store quiz questions, evaluate answers, and calculate learner performance.
- **Weak Topic Detection:** Identify topics where quiz accuracy is below 60%.
- **Personalized Recommendations:** Recommend lessons related to weak topics.
- **Adaptive Recommendations:** Rank incomplete lessons using topic accuracy, module order, and lesson order.
- **Progress Tracking:** Record lesson status, completion percentage, and time spent learning.
- **Progress Dashboard API:** Calculate course-level and module-level progress.

## Tech Stack

| Technology          | Purpose                           |
| ------------------- | --------------------------------- |
| Java                | Backend programming               |
| Spring Boot         | REST API development              |
| Spring Data MongoDB | Database integration              |
| MongoDB             | Persistent data storage           |
| Google Gemini API   | Generative AI integration         |
| Maven               | Dependency management and builds  |
| Postman             | API testing                       |
| Git and GitHub      | Version control and collaboration |

**Planned technologies:** React with TypeScript, Spring Security and JWT, automated testing, Redis, Kafka, Docker, and AWS.

## Architecture

```text
Client / Postman
       |
       v
Spring Boot REST API
       |
       +--> Course, Module and Lesson Services
       |
       +--> Quiz and Evaluation Services
       |
       +--> Weak Topic Analysis
       |
       +--> Adaptive Recommendation Engine
       |
       +--> Progress Tracking Services
       |
       +--> Gemini AI Integration
       |
       v
    MongoDB
```

## Example: Adaptive Recommendations

The recommendation engine uses learner performance to prioritize lessons.

For example, when a learner has low accuracy in MongoDB:

1. Identify MongoDB as a weak topic.
2. Retrieve relevant lessons.
3. Exclude lessons already completed.
4. Calculate a recommendation score using topic accuracy and lesson sequence.
5. Return recommendations in descending score order.

The current implementation uses a **rule-based scoring algorithm**, rather than a trained machine-learning model.

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint                                         | Purpose                             |
| ------ | ------------------------------------------------ | ----------------------------------- |
| GET    | `/api/health`                                    | Check application health            |
| GET    | `/api/recommendations/{learnerId}`               | Get basic recommendations           |
| GET    | `/api/recommendations/adaptive/{learnerId}`      | Get ranked adaptive recommendations |
| GET    | `/api/weak-topics/{learnerId}`                   | Retrieve weak topics                |
| POST   | `/api/progress`                                  | Create or update lesson progress    |
| GET    | `/api/progress/course/{learnerId}/{courseId}`    | Get course progress                 |
| GET    | `/api/progress/module/{learnerId}/{moduleId}`    | Get module progress                 |
| GET    | `/api/progress/dashboard/{learnerId}/{courseId}` | Get the learner progress dashboard  |

Additional course, module, lesson, quiz, and AI endpoints are available in the backend.

## Getting Started

### Prerequisites

- Java version compatible with the project's `pom.xml`
- Maven, or the included Maven Wrapper
- MongoDB running locally or a MongoDB connection URI
- Google Gemini API key for features that call Gemini
- Git

### 1. Clone the repository

```bash
git clone https://github.com/SanketBhapkar-12/ai-learning-platform.git
cd ai-learning-platform
```

### 2. Configure environment variables

Configure your MongoDB connection and Gemini API key according to your 'src/main/resources/application.properties'.

Set your Gemini API key in your environment rather than committing secrets to Git.

**Windows PowerShell example:**

powershell:- 
$env:GEMINI_API_KEY = "your-api-key"

Use your actual local MongoDB configuration. Do not publish passwords, API keys, or connection strings containing credentials.

### 3. Run the application

On Windows:-

powershell:-
.\mvnw.cmd spring-boot:run


Or compile the project:

powershell
.\mvnw.cmd compile


The application is configured to run on port '8080' unless you change its configuration.

### 4. Check the health endpoint

GET http://localhost:8080/api/health

You can also test the APIs using Postman.

## Example Adaptive Recommendation Request


GET http://localhost:8080/api/recommendations/adaptive/user-1

The response includes the lesson ID, title, topic, estimated study time, topic accuracy, priority, recommendation score, and explanation.

## Development Roadmap

- [*] Course, module, and lesson APIs
- [*] Gemini API integration foundation
- [*] Quiz evaluation
- [*] Weak topic detection
- [*] Personalized lesson recommendations
- [*] Adaptive recommendation scoring
- [*] Lesson progress tracking
- [*] Course and module progress dashboard
- [ ] Authentication and authorization
- [ ] Automated unit and integration tests
- [ ] Personalized learning plans
- [ ] AI tutor and document-based learning
- [ ] React + TypeScript frontend
- [ ] Redis caching and Kafka-based asynchronous processing
- [ ] Docker deployment and AWS hosting
- [ ] Monitoring and load testing

## Learning Outcomes

This project is intended to demonstrate practical skills in:

- Designing RESTful backend services
- Building layered applications with Spring Boot
- Working with MongoDB and persistent data models
- Integrating a generative AI API
- Analyzing learner performance and designing recommendation rules
- Tracking progress and aggregating application data
- Testing APIs and managing code with Git

## author** - Sanket Bhapkar

GitHub: [SanketBhapkar-12](https://github.com/SanketBhapkar-12)


This project is being developed incrementally, with a focus on understanding backend engineering, AI integration, and scalable application design.