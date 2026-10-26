# Produtos API

API REST para gerenciamento de produtos, desenvolvida com **Spring Boot** como projeto de estudo. O objetivo é praticar a construção de uma aplicação Java moderna utilizando as principais ferramentas do ecossistema Spring.

## 🚀 Tecnologias

- Java 21
- Spring Boot 4.1.2
- Spring Web (MVC)
- Spring Data JPA
- Banco de dados H2 (em memória)
- Lombok
- Maven

## 📁 Estrutura do projeto

```
src/main/java/com/example/produtosapi
├── ProdutosapiApplication.java   # Classe principal (entry point)
├── controller
│   └── ProductController.java   # Endpoints REST de produtos
├── model
│   └── Product.java              # Entidade/POJO de produto
└── repository
    └── ProductRepository.java    # Acesso a dados (Spring Data JPA)
```

## ▶️ Como executar

Pré-requisitos: **Java 21** e **Maven** (ou use o wrapper incluso no projeto).

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/produtosapi.git
cd produtosapi

# Rodar a aplicação
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## 📌 Endpoints

| Método | Rota             | Descrição                                   |
|--------|------------------|----------------------------------------------|
| POST   | `/products`      | Cadastra um novo produto (o `id` é gerado)   |
| GET    | `/products?name=`| Busca produtos pelo nome (contém o termo)    |
| GET    | `/products/{id}` | Busca um produto pelo ID                     |
| PUT    | `/products/{id}` | Atualiza um produto existente                |
| DELETE | `/products/{id}` | Remove um produto pelo ID                    |

Exemplo de requisição (POST e PUT):

```json
POST /products
Content-Type: application/json

{
  "name": "Notebook",
  "description": "Notebook 15 polegadas",
  "price": 3500.00
}
```

> No `POST`, o `id` é gerado automaticamente (UUID). No `PUT`, o `id` da URL é utilizado.

Exemplos:

```bash
curl http://localhost:8080/products/{id}
curl "http://localhost:8080/products?name=Note"
curl -X PUT http://localhost:8080/products/{id} -H "Content-Type: application/json" \
  -d '{"name":"Notebook","description":"Novo","price":3200.00}'
curl -X DELETE http://localhost:8080/products/{id}
```

## 🧪 Testes

```bash
./mvnw test
```

## 📄 Licença

Este projeto está sob a licença MIT.
