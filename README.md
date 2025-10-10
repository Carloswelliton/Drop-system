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
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## 📦 Estrutura do Projeto

```bash
📦backend
 ┣ 📂DTO
 ┃ ┣ 📜DadosAuth.java
 ┃ ┣ 📜TokenJWT.java
 ┃ ┣ 📜UserDTO.java
 ┃ ┗ 📜UserUpdateDTO.java
 ┣ 📂config
 ┃ ┗ 📂security
 ┃ ┃ ┣ 📜SecurityConfigurations.java
 ┃ ┃ ┣ 📜SecurityFilter.java
 ┃ ┃ ┗ 📜TokenService.java
 ┣ 📂controllers
 ┃ ┣ 📜AuthController.java
 ┃ ┣ 📜TestController.java
 ┃ ┗ 📜UserController.java
 ┣ 📂exceptions
 ┣ 📂models
 ┃ ┣ 📜Drop.java
 ┃ ┣ 📜Foto.java
 ┃ ┣ 📜OrdemServico.java
 ┃ ┣ 📜Roles.java
 ┃ ┗ 📜User.java
 ┣ 📂repository
 ┃ ┣ 📜DropRepository.java
 ┃ ┣ 📜OrdemServicoRepository.java
 ┃ ┗ 📜UserRepository.java
 ┣ 📂service
 ┃ ┣ 📜AuthService.java
 ┃ ┗ 📜UserService.java
 ┗ 📜BackendApplication.java
```
---

## 🔑 Autenticação JWT
| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| POST | `/auth/login` | Gera token |
| POST | `/auth/register` | Cadastra novo usuário |
| GET | `/auth/test` | Endpoint livre para teste |

---

## 🧭 Milestones
- v0.1.0 - Autenticação e usuários
- v0.2.0 - Ordens de serviço
- v0.3.0 - Upload de fotos
- v0.4.0 - Integração apps
- v1.0.0 - Produção

---


## 🧩 Contribuindo
1. Crie uma branch: `git checkout -b feature/nome-feature`
2. Commit: `git commit -m "feat: adiciona nova feature"`
3. Push: `git push origin feature/nome-feature`
4. Abra um Pull Request

## 🐳 Docker
```bash
docker-compose up -d
```

## 🛠️ Em desenvolvimento