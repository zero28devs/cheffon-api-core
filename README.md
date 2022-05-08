# Cheffon API

## Configuração Projeto

### Requisitos básicos

Para rodar o projeto as seguintes ferramentas devem estar configuradas em sua máquina:

- Java (versão 17)
- Docker e Docker Compose
- Gitflow

### Gitflow

Para controle de branchs do projeto é utilizado o `gitflow`, desse modo, ao clonar o projeto é necessário configurá-lo.
Com o `gitflow` configurado basta executar o seguinte comando para iniciar a configuração:

```
$ git flow feature init
```

Ao executar o comando será necessário definir os branchs principais, siga o fluxo exibido abaixo:

- Produção: `main`
- Desenvolvimento: `develop`
- Feature: `feature/`
- Bugfix: `bugfix/`
- Release: `release/`
- Hotfix: `hotfix/`
- Suporte: `support/`
- Prefixo de Versão da Tag: `[]` 

### Iniciando os serviços

Para rodar todos os serviços usados na API é necessário ter o `docker` e `docker-compose` configurado. Feito isso, basta
executar o comando abaixo para iniciar os serviços:

```shell
$ docker-compose up -d
````

Para finalizar os serviços basta executar o seguinte comando:

```shell
$ docker-compose down
```

### Configurando banco de dados

Ao executar o serviço de banco de dados pela primeira vez no `docker` é necessário criar o banco de dados no PostgreSQL 
para que o projeto possa ser executado corretamente, para isso acesse o banco de dados com alguma ferramenta (como 
`plsql`, `dbeaver`, `pgadmin`) usando os seguintes dados:

- Endereço: `localhost`
- Porta: `5433`
- Usuário: `postgres`
- Senha: `postgres`

Após isso, execute o seguinte comando para criar o banco:

```sql
CREATE DATABASE api WITH OWNER postgres;
```

### Documentação

Para acessar documentação da API do projeto, basta acessar a URL abaixo:

```bash
http://localhost:8080/swagger-ui/index.html
```

### Verificar cobertura dos testes

Para verificar a cobertura de testes, basta executar o seguinte comando (ou rodar pela aba Maven no IntelliJ):

```bash
./mvnw verify
```

Os relatórios de cobertura de testes estão disponíveis no diretório **target/site/jacoco/index.html**

### OBS (TIRAR ASSIM QUE GERAR DOC)

Criar no dokku uma variavel de ambiente com o seguinte comando:

```bash
dokku config:set appNoDokku SPRING_PROFILES_ACTIVE=prod
```
