# API de Gerenciamento de Produtos


![Java](https://img.shields.io/badge/Java-17+-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

Este projeto é uma **API REST de gestão de produtos** desenvolvida em Spring Boot, que oferece operações CRUD (criar, ler, atualizar, deletar) sobre um recurso *Produto*.  
O objetivo é fornecer um serviço backend simples e robusto para cadastrar, consultar, atualizar e remover produtos.  

Por ser baseada em Spring Boot, a aplicação aproveita a configuração automática do framework para inicializar uma aplicação web completa em Java puro (sem XML).  
Os dados dos produtos são persistidos em um banco relacional usando **Spring Data JPA** (com suporte, por exemplo, ao banco H2 em memória durante o desenvolvimento).

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot** – configuração automática e servidor web embutido.  
- **Spring Web MVC** – exposição de endpoints REST.  
- **Spring Data JPA** – persistência de dados com JPA/Hibernate.  
- **Banco de Dados** – H2 (dev).  
- **Java 17+** – versão mínima recomendada.  
- **Maven** – build e gerenciamento de dependências.  

---

## ⚙️ Como Executar Localmente

1. **Pré-requisitos:** JDK 17+ e Maven.  
2. Clone o repositório:
   ```bash
   git clone https://github.com/swetonyancelmo/api-produtos.git
   cd api-produtos
   ```
3. Execute a aplicação:
   - Via Maven:
      ```bash
      mvn spring-boot:run
      ```
   - Via Jar:
      ```bash
      mvn clean package
      java -jar target/api-produtos.jar
      ```
4. Acesse em: ``http://localhost:8080``

## 📌 Endpoints da API

**🔹 Listar todos os produtos:**

   - GET localhost:8080/produtos
  
  - Descrição: Retorna todos os produtos cadastrados.

  - Resultado: 200 OK
  ```bash
    {
      "id": 1,
      "nome": "Samsung A56",
      "preco": 1200,
      "descricao": "256gb de Memória, 8gb de RAM"
    }
  ```

---

**🔹 Buscar produto por ID:**

- GET localhost:8080/produtos/id

- Descrição: Retorna o produto com o ID informado.

- Resposta (200 OK):

```bash
{
    "id": 2,
    "nome": "iPhone 15",
    "preco": 8000,
    "descricao": "Produto teste"
}
```
- Erro: 404 Not Found se não existir.
---

**🔹 Criar novo produto:**

- POST localhost:8080/produtos
- Descrição: Cadastra um novo produto.
- Payload:
```bash
  {
    "nome": "Produto Teste",
    "preco": 999.99,
    "descricao": "Descrição Teste"
  }
```
Resposta (200 Ok):
```bash
{
    "id": 3,
    "nome": "Produto Teste",
    "preco": 999.99,
    "descricao": "Descrição Teste"
}
```
---

**🔹 Atualizar produto:**

- PUT localhost:8080/produtos/{id}
- Descrição: Atualiza os dados de um produto existente.
- Payload:
```bash
  {
    "nome": "Produto Atualizado",
    "preco": 999.99,
    "descricao": "Descrição Atualizada"
  }
```
- Resposta (200 OK):
```bash
{
    "id": 3,
    "nome": "Produto Atualizado",
    "preco": 999.99,
    "descricao": "Descrição Atualizada"
}
```
- Erro: 404 Not Found se não existir

---

** 🔹 Deletar produto:**

- DELETE localhost:8080/produtos/{id}
- Resposta: 204 No Content
- Erro: 404 Not Found se não existir.

# 📂 Estrutura do Projeto:

```bash
api-produtos/
├─ pom.xml
└─ src/
   ├─ main/
   │   ├─ java/com/swetony/
   │   │   ├─ EstoqueApplication.java
   │   │   ├─ controller/ProdutoController.java
   │   │   ├─ entity/Produto.java
   │   │   ├─ repository/ProdutoRepository.java
   │   │   └─ service/ProdutoService.java
   │   └─ resources/
   │       ├─ application.properties
   └─ test/
```
# 🔮 Possíveis Melhorias Futuras

- ✅ Validações de entrada e mensagens de erro detalhadas
- ✅ Documentação interativa com Swagger
- ✅ Paginação e filtros de pesquisa
- ✅ Autenticação/autorização (JWT/OAuth2)
- ✅ Banco real (MySQL/PostgreSQL)
- ✅ Testes automatizados (unitários e integração)
- ✅ Deploy com Docker e CI/CD

---

💡 Este projeto demonstra boas práticas no desenvolvimento de APIs REST com Spring Boot e pode ser expandido para cenários reais de mercado.

Desenvolvido por [Swetony Ancelmo](https://www.linkedin.com/in/swetony-ancelmo)


