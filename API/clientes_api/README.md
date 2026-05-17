# API de Gerenciamento de Clientes
### Projeto Faculdade — Spring Boot

---

## Estrutura do Projeto

```
clientes-api/
├── pom.xml                                         ← dependências Maven
└── src/main/java/com/loja/clientes/
    ├── ClientesApiApplication.java                 ← classe principal (main)
    ├── model/
    │   └── Cliente.java                            ← CAMADA MODEL
    ├── service/
    │   └── ClienteService.java                     ← CAMADA SERVICE
    └── controller/
        └── ClienteController.java                  ← CAMADA CONTROLLER
```

---

## Como Executar

### Pré-requisitos
- Java 17 ou superior instalado
- Maven instalado (ou usar a IDE diretamente)

### Via terminal (Maven)
```bash
cd clientes-api
mvn spring-boot:run
```

### Via IDE (IntelliJ / Eclipse / VS Code)
1. Abra a pasta `clientes-api` como projeto Maven
2. Aguarde o download das dependências
3. Execute a classe `ClientesApiApplication.java`

A API estará disponível em: **http://localhost:8080**

---

## Endpoints Disponíveis

| Método | URL                 | Descrição                        | Status de Sucesso |
|--------|---------------------|----------------------------------|-------------------|
| GET    | /clientes           | Lista todos os clientes          | 200 OK            |
| GET    | /clientes/{id}      | Busca um cliente pelo ID         | 200 OK            |
| POST   | /clientes           | Cadastra um novo cliente         | 201 Created       |
| PUT    | /clientes/{id}      | Atualiza dados de um cliente     | 200 OK            |
| DELETE | /clientes/{id}      | Remove um cliente pelo ID        | 204 No Content    |

---

## Testando com Postman / Insomnia

### 1. Cadastrar um cliente (POST)

- **Método:** POST
- **URL:** `http://localhost:8080/clientes`
- **Headers:** `Content-Type: application/json`
- **Body (JSON):**
```json
{
    "nome": "Maria Souza",
    "email": "maria@email.com",
    "idade": 28
}
```
- **Resposta esperada (201 Created):**
```json
{
    "id": 1,
    "nome": "Maria Souza",
    "email": "maria@email.com",
    "idade": 28
}
```

---

### 2. Listar todos os clientes (GET)

- **Método:** GET
- **URL:** `http://localhost:8080/clientes`
- **Resposta esperada (200 OK):**
```json
[
    {
        "id": 1,
        "nome": "Maria Souza",
        "email": "maria@email.com",
        "idade": 28
    }
]
```

---

### 3. Buscar cliente por ID (GET)

- **Método:** GET
- **URL:** `http://localhost:8080/clientes/1`
- **Resposta esperada (200 OK):**
```json
{
    "id": 1,
    "nome": "Maria Souza",
    "email": "maria@email.com",
    "idade": 28
}
```
- **Se o ID não existir → 404 Not Found**

---

### 4. Atualizar um cliente (PUT)

- **Método:** PUT
- **URL:** `http://localhost:8080/clientes/1`
- **Headers:** `Content-Type: application/json`
- **Body (JSON):**
```json
{
    "nome": "Maria Silva Souza",
    "email": "maria.nova@email.com",
    "idade": 29
}
```
- **Resposta esperada (200 OK):**
```json
{
    "id": 1,
    "nome": "Maria Silva Souza",
    "email": "maria.nova@email.com",
    "idade": 29
}
```
- **Se o ID não existir → 404 Not Found**

---

### 5. Remover um cliente (DELETE)

- **Método:** DELETE
- **URL:** `http://localhost:8080/clientes/1`
- **Resposta esperada:** `204 No Content` (sem corpo)
- **Se o ID não existir → 404 Not Found**

---

## Arquitetura — Fluxo da Requisição

```
Cliente HTTP (Postman/Browser)
        │
        ▼
  [Controller]          ← recebe a requisição, valida a URL e o corpo
  ClienteController
        │
        ▼
  [Service]             ← contém a lógica de negócio
  ClienteService
        │
        ▼
  List<Cliente>         ← "banco de dados" em memória (ArrayList)
```

---

## Códigos HTTP Utilizados

| Código | Nome           | Quando é retornado                          |
|--------|----------------|---------------------------------------------|
| 200    | OK             | GET e PUT com sucesso                       |
| 201    | Created        | POST — recurso criado com sucesso           |
| 204    | No Content     | DELETE — recurso removido com sucesso       |
| 404    | Not Found      | ID informado não existe na lista            |
