# Agendaki

Este projeto é uma aplicação web desenvolvida como parte da disciplina de laboratório de programação, utilizando Java, Spring Boot, Spring Data JPA e Thymeleaf. O objetivo é gerenciar agendamentos de forma simples com persistência em banco de dados relacional e validações de formulário.

## Integrantes
- Leonam Alves
- Nadson Costa

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Flyway Migration
- Jakarta Bean Validation
- Thymeleaf
- HTML5, CSS3, JavaScript

## Configuração do Banco de Dados
Antes de executar a aplicação, certifique-se de ter o PostgreSQL rodando localmente e crie o banco de dados:

```sql
CREATE DATABASE agendaki;
```
## Como Executar
1. Certifique-se de ter o JDK instalado.
2. Clone o repositório.
3. No terminal, dentro da pasta do projeto, execute:
    - Linux/Mac: `./mvnw spring-boot:run`
    - Windows: `mvnw.cmd spring-boot:run`
4. Acesse `http://localhost:8080` no seu navegador.

## Principais Rotas

### Geral
- `/`: Página inicial (Dashboard)

### Agendamentos
- `/agendamentos`: Listagem de agendamentos
- `/agendamentos/novo`: Formulário para criar novo agendamento

### Clientes
- `/clientes`: Listagem de clientes
- `/clientes/novo`: Formulário para cadastrar novo cliente

### Profissionais
- `/profissionais`: Listagem de profissionais
- `/profissionais/novo`: Formulário para cadastrar novo profissional

### Categorias
- `/categorias`: Listagem de categorias
- `/categorias/novo`: Formulário para cadastrar nova categoria Formulário para criar um novo agendamento