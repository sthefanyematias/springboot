# Guia Restaurante

API REST desenvolvida durante as aulas de Spring Boot para aplicação dos conceitos fundamentais de desenvolvimento backend com Java.

### Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok

### Recursos

- Usuários
- Restaurantes
- Tipos de Restaurante
- Tipos de Prato
- Pratos em Destaque
- Avaliações

### Configuração

Antes de executar a aplicação, atualize as configurações de acesso ao banco de dados no arquivo `application.properties`.

```properties
app.datasource.url=jdbc:mysql://localhost:3306/guiarestaurante?createDatabaseIfNotExist=true
app.datasource.username=seu_usuario
app.datasource.password=sua_senha
```

### Execução

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

### Documentação

A especificação OpenAPI está disponível em:

```text
docs/openapi.yaml
```

### Objetivo

Projeto desenvolvido para fins educacionais durante o aprendizado de Spring Boot, abordando persistência de dados, arquitetura em camadas e construção de APIs REST.
