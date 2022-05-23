# ELK Stack

This project is an example of microservice using ELK Stack. It was based on the [Spring-Security](https://github.com/ricardorqr/spring-security) project.

# Running the application.

### 1. Docker

In the root project folder, run the command:

```shell
<spring-elk>$ docker compose up
```

Here is how to check the database

- URL: [http://localhost:8080/?server=mariadb](http://localhost:8080/?server=mariadb)
- Server: mariadb
- Username: root
- Password: example
- Database: example
- Insert user:

```sqlite-sql
insert into example.user (id, name, password, username) values (1, "RicoRibeiro", "$2a$10$01KY2xuPr8iNq3QokJ1c1OuUNZw6rPmqYQSjAFh91PY.pOnPP0MX2", "ricoribeiro");
```

![Table Customer](.files/MariaDB01.png)

### 2. Run application

```shell
<elk>$ mvn spring-boot:run
```

### 3. Postman

###### Get token

- POST: [http://localhost:8081/login](http://localhost:8081/login)
- Body:

```json
{
    "username": "ricoribeiro",
    "password": "ricardo123"
}
```

- Response:

```json
{
    "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk",
    "refresh_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk"
}
```

###### Any other request

Use the given `access_token` in the next request.
Header:
```properties
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk
```

### 4. Kibana

- Login: elastic
- Password: changeme

# Links

- Kibana: [http://localhost:5601/login?next=%2F](http://localhost:5601/login?next=%2F)
- Database: [http://localhost:8080/?server=mariadb](http://localhost:8080/?server=mariadb)
- Swagger: [http://localhost:8081/swagger](http://localhost:8081/swagger)

# Resources

- https://www.youtube.com/watch?v=9g-h1biMn2E
- https://www.youtube.com/watch?v=5s9pR9UUtAU
- https://github.com/elastic/elasticsearch
- https://github.com/deviantony/docker-elk
- https://github.com/buraksarp/docker-elk
- https://github.com/janitham/spring-boot-elk-stack
- https://github.com/cassiomolin/log-aggregation-spring-boot-elastic-stack
