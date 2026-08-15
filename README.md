# Consome API Brasil

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=for-the-badge&logo=spring)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

Aplicação web em Spring Boot para consultar dados públicos brasileiros (como CEP e CNPJ) consumindo APIs externas, com renderização server-side via Thymeleaf e estilização com Tailwind CSS.

O objetivo do projeto foi praticar integração com serviços externos, estruturação de camadas no backend e empacotamento com Docker.

<img src="https://i.imgur.com/j0pgA6G.png" alt="Tela inicial do projeto" width="100%">

---

## 📌 O que a aplicação faz

- **Consulta de CEP**: Busca logradouro, bairro, cidade e estado a partir do CEP digitado.
- **Consulta de CNPJ**: Retorna dados cadastrais da Receita Federal (razão social, porte, endereço, status e contato).
- **Interface no terminal/dark mode**: Layout escuro construído com Tailwind CSS e adaptado para telas mobile e desktop.
- **Feedback de erros na tela**: Mensagens amigáveis para CEPs/CNPJs inválidos ou não localizados na base.

---

## 🧱 Decisões técnicas e arquitetura

- **Java Records para DTOs**: Uso de `record` para separar o payload que vem da API externa (`ResponseDTO`) do objeto que o Thymeleaf consome (`ViewDTO`), mantendo imutabilidade sem boilerplate.
- **Camada de Serviço Isolada**: As chamadas HTTP via `RestTemplate` e as regras de transformação dos dados ficam nos Services, deixando os Controllers responsáveis apenas por receber a requisição e devolver a view.
- **Tratamento Global de Erros com `@ControllerAdvice`**: Centraliza o tratamento de exceções (como 404 de registros inexistentes ou falhas na API externa) sem poluir o código com `try/catch` em todo endpoint.
- **Helpers Utilitários**: Métodos estáticos para formatação de máscaras (CPF, CNPJ, CEP) e strings, evitando lógica complexa direto nas tags do Thymeleaf.

---

## 🚀 Como Executar Localmente

### Opção 1: Rodando nativamente com Maven
*Pré-requisito: Java 17+*
1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/consome-api-brasil.git
   ```
2. Acesse a pasta do projeto e rode:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Acesse no navegador: `http://localhost:8080`

### Opção 2: Rodando com Docker (Recomendado)
*Pré-requisito: Docker Desktop instalado*
1. Construa a imagem da aplicação:
   ```bash
   docker build -t consome-api-brasil .
   ```
2. Inicie o container:
   ```bash
   docker run -p 8080:8080 consome-api-brasil
   ```
3. Acesse no navegador: `http://localhost:8080`

---
