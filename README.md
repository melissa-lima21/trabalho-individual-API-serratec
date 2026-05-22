# API - ONG de Animais 🐾

Este projeto consiste em uma API REST desenvolvida como Trabalho Individual para a disciplina de Desenvolvimento de API do programa **Serratec**. O sistema foi projetado para gerenciar o fluxo de adoção de animais em uma ONG, conectando pessoas interessadas aos animais disponíveis, além de categorizar as características de cada pet.

## 👤 Desenvolvedora
* **Nome:** Melissa Lima da Silva
* **Repositório:** [GitHub - Trabalho Individual API](https://github.com/melissa-lima21/trabalho-individual-API-serratec/tree/main)

---

## 🚀 Tecnologias Utilizadas
* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA** (Persistência de dados)
* **PostgreSQL** (Banco de dados relacional)
* **Bean Validation / Jakarta Validation** (Validação de dados de entrada)
* **Springdoc OpenAPI / Swagger** (Documentação automatica da API)
* **Maven** (Gerenciador de dependências)

---

## 🛠️ Arquitetura e Organização do Projeto
O projeto segue o padrão de camadas recomendado pelas boas práticas do Spring Boot:
* `domain`: Entidades mapeadas para as tabelas do banco de dados relacional.
* `repository`: Interfaces de comunicação e consultas com o banco de dados via Spring Data.
* `service`: Camada de regras de negócio, validações e conversões utilizando DTOs.
* `controller`: Camada que expõe os endpoints HTTP da API.
* `dto`: Objetos de transferência de dados separados rigidamente entre `Request` (entrada) e `Response` (saída).
* `exception`: Estrutura de tratamento global de erros da API.
* `config`: Configurações adicionais do sistema (Swagger/OpenAPI).

---

## 🗄️ Entidades Principais
1. **Pessoa:** Representa os adotantes interessados.
2. **Animal:** Representa os animais cadastrados na ONG.
3. **Caracteristica:** Características associadas aos animais (ex: "Dócil", "Castrado", "Brincalhão").
4. **InteresseAdocao:** Entidade de relacionamento que vincula uma Pessoa a um Animal específico, registrando a data e o status do processo.

---

## 📡 Endpoints Principais (Rotas)

### 🐾 Animais (`/animais`)
* `GET /animais` - Lista todos os animais cadastrados.
* `GET /animais/{id}` - Busca um animal específico por ID.
* `POST /animais` - Cadastra um novo animal.
* `PUT /animais/{id}` - Atualiza os dados de um animal existente.
* `DELETE /animais/{id}` - Remove um animal do sistema.

### 👥 Pessoas (`/pessoas`)
* `GET /pessoas` - Lista todas as pessoas registradas.
* `POST /pessoas` - Cadastra um novo interessado.

### 📝 Interesses de Adoção (`/interesses`)
* `POST /interesses` - Registra a intenção de uma pessoa adotar um determinado animal.
  * *Exemplo de Payload:*
    ```json
    {
      "interessadoId": 1,
      "animalId": 2,
      "status": "AGUARDANDO"
    }
    ```

---

## 🛡️ Tratamento de Erros e Exceções (Custom Exceptions)
A aplicação possui um manipulador global de exceções (`@ControllerAdvice`) que intercepta falhas e retorna respostas limpas e padronizadas no formato JSON, incluindo propriedades como `status`, `titulo` e `dataHora`.

As seguintes exceções customizadas foram implementadas para garantir a integridade das regras de negócio:
* **`SolicitacaoNaoEncontradaException` (HTTP 404):** Disparada quando um ID enviado na requisição (como ID de pessoa ou animal) não existe no banco de dados.
* **`DuplicateEntryException` (HTTP 409):** Disparada ao tentar cadastrar registros duplicados que violam regras de unicidade (como descrições repetidas de características).
* **`EnumValidationException` (HTTP 400):** Captura falhas na tentativa de enviar status inválidos que não constam nas listas pré-definidas (Enums).

---

## 📖 Documentação da API (Swagger)
A API conta com documentação interativa integrada através do Swagger UI. Para visualizar os endpoints mapeados, os esquemas dos DTOs e realizar testes das requisições diretamente pelo navegador, certifique-se de que a aplicação está rodando e acesse:

> **URL de Acesso:** [http://localhost:8080/swagger](http://localhost:8080/swagger)

---

## ⚙️ Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/melissa-lima21/trabalho-individual-API-serratec.git](https://github.com/melissa-lima21/trabalho-individual-API-serratec.git)
