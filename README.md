# fiap-fase1
## Aluno: Bruno Ferreira da Silva  
## Tech Challenge - Fase 1  

# 1. ARQUITETURA DA APLICAÇÃO  
A aplicação foi desenvolvida utilizando a arquitetura em camadas (Layered Architecture), baseada no padrão REST.  
As camadas são organizadas da seguinte forma:  
Controller: responsável por expor os endpoints da API REST.  
Service: contém as regras de negócio da aplicação.  
Repository: responsável pelo acesso ao banco de dados utilizando Spring Data JPA.  
Model: representa as entidades persistidas no banco.  
DTO: utilizado para entrada e saída de dados, garantindo desacoplamento.  
Exception Handler: responsável pelo tratamento global de erros utilizando o padrão ProblemDetail (RFC 7807).  


# 2. MODELAGEM DAS ENTIDADES  
### Entidade Usuario  
id (Long) – chave primária  
nome (String)  
email (String) – único  
login (String)  
senha (String)  
tipo (Enum)  
endereco (String)  
dataUltimaAlteracao (LocalDateTime)  
 Relacionamentos  
Neste projeto não há relacionamentos entre entidades, sendo composta apenas pela entidade Usuario.  

# 3. ENDPOINTS DA API  
 ## Criar usuário  
POST /api/v1/usuarios  
Request:  
{  
 "nome": "Bruno",  
 "email": "teste@teste.com",  
 "login": "teste",  
 "senha": "123",  
 "endereco": "Rua X",  
 "tipo": "CLIENTE"  
}  
Response:  
{  
 "id": 1,  
 "nome": "Bruno",  
 "email": "teste@teste.com",  
 "login": "teste",  
 "tipo": "CLIENTE",  
 "endereco": "Rua X"  
}  

## Buscar por nome  
GET /api/v1/usuarios?nome=bruno  

## Alterar senha  
PATCH /api/v1/usuarios/{id}/senha  

## Login  
POST /api/v1/usuarios/login?login=teste&senha=123  



# 4. DOCUMENTAÇÃO SWAGGER  
A aplicação utiliza Springdoc OpenAPI para documentação automática dos endpoints.  
A documentação pode ser acessada em:  
http://localhost:8080/swagger  




# 5. BANCO DE DADOS  
O banco de dados utilizado foi o PostgreSQL.  
## Estrutura da tabela:  
usuarios  
- id (PK)  
- nome  
- email (UNIQUE)  
- login  
- senha   
- tipo  
- endereco  
- data_ultima_alteracao  




# 6. EXECUÇÃO COM DOCKER  
A aplicação pode ser executada utilizando Docker Compose.  
docker-compose.yml  
services:  
 db:  
   image: postgres:15  
   environment:  
     POSTGRES_DB: app  
     POSTGRES_USER: postgres  
     POSTGRES_PASSWORD: 123  
   ports:  
     - "5432:5432"
       
## Passo a passo:  
docker compose up -d  
mvn clean install  
run aplicação  

## Variáveis de ambiente:  
spring:  
 datasource:  
   url: jdbc:postgresql://localhost:5432/app  
   username: postgres  
   password: 123  






## Tratamento de erros (ProblemDetail)  
A aplicação utiliza o padrão RFC 7807 para padronização de erros.  
Exemplo:  
{  
 "type": "https://api.fiap.com/errors/validacao",  
 "title": "Erro de validação",  
 "status": 400,  
 "detail": "Email obrigatório",  
 "instance": "/api/v1/usuarios"  
}  



# 7. COLEÇÃO POSTMAN
Foi criada uma coleção no Postman contendo todos os endpoints da aplicação para facilitar testes.  




## Extra:  

### Testes Unitários:  



## GITHUB:  

https://github.com/brunof23/fiap-fase1/tree/main  



