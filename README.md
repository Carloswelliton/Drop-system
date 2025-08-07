# DROP

## Descrição
Backend para gerenciamento de dados, desenvolvido para organizar e processar informações de forma eficiente. 
- Backend - Em desenvolvimento
- sistema Web - A desenvolver
- Mobile - A desenvolver

## Funcionalidades
- API RESTful para gerenciamento de dados
- Autenticação de usuários
- CRUD para entidades principais
- Envio assincrono entre app mobile e backend para uma página de controle web

## Tecnologias utilizadas
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

## Instalação
1. Clone o repositório:
```
git clone https://github.com/Carloswelliton/Drop-system.git
```
2. Acesse o diretório:
```
cd backend
```
3. configure as configurações no application.properties:
```
spring.application.name=backend

spring.datasource.url=jdbc:postgresql://localhost:5432/database_name
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
4. Inicie o servidor:
```
mvn spring-boot:run
```

## 🛠️ Em desenvolvimento