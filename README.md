# hometaskmanagementREST
SpringBoot REST API to manage home task. SpringBoot is a popular and suitable backend option for developing selling API for serveral reasons:
1. Rapid Deployment
2. Spring Ecosystem
3. Convention over configuration
4. Dependency Management
5. Integration Capabilities
6. Microservices Support

## Functionalities:
* Can add tasks
* View Task
* Complete task
* Delete task

### RESTapi END POINTS

GET : ‘/api/tasks’ -> retrieve a list of all tasks.

GET : ‘/api/tasks/{id} -> retrieve a specific task by ID

POST : ‘/api/tasks’ -> create a new task

PUT : ‘/api/tasks/{id}’ -> update an existing task by ID

PATCH : ‘/api/tasks/{id}’ -> mark a task as complete by ID

DELETE : ‘/api/tasks/{id}’ -> delete a task by ID

### dependencies used:
* Spring boot data JPA
* Spring boot web
* mysql connector 
* Lombok
##### Folder Structure
- Controller 
- Entity
- Repository
