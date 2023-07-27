# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este projeto é uma API que desenvolvida com **Java, Java Spring, MySQL como banco de dados, e Spring Security e JWT para controle de auntenticação.**

Tive como inspiração e referência para o desenvolvimento e implementação do Spring Security o [Youtube Tutorial](https://www.youtube.com/watch?v=5w-YCcOjPD0) da FernandaKipper.

## API Endpoints
A API fornece os seguintes endpoints:

```markdown
GET /products - Retorna uma lista de todos os produtos. (todos os usuários autenticados tem acesso)

POST /products - Registra um novo produto (é necessário que o usuário seja um ADMIN).

POST /auth/login - Login na aplicação.

POST /auth/register - Registra um novo usuário na aplicação.
```

## Authentication
A API usa Spring Security para controle de autenticação. As seguintes funções estão disponíveis:

```
USER -> Função de usuário padrão para usuários conectados.
ADMIN -> Função de administrador para sócios-gerentes (registro de novos sócios).
```
Para acessar endpoints protegidos como um usuário ADMIN, forneça as credenciais de autenticação apropriadas no cabeçalho da solicitação.