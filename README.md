# Simple Task Manager

A minimal Spring Boot task manager with in-memory storage.

## Features
- Add users
- Create, update, and delete tasks per user
- Web interface and REST API
- No database required

## Quick Start
```bash
mvn spring-boot:run
```

Open http://localhost:8080

## API Endpoints
- `POST /api/users?name=John` - Create user
- `GET /api/users` - List users
- `POST /api/tasks?title=Task&description=Desc&userId=1` - Create task
- `GET /api/tasks/user/1` - Get user tasks
- `PUT /api/tasks/1/status?completed=true` - Update task status
- `DELETE /api/tasks/1` - Delete task

## Requirements
- Java 17+
- Maven