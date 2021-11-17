# Projeto Desafio INEMA/FUNBIO

#### **Sistema de Gestão de Pessoas**



#### Tecnologias utilizadas

- Java - v11;
- Spring Tools 4 - v4.12.1;
- Spring Boot - v2.5.6;
- JPA - v2.5.6
- Hibernate Validator - v7.0.1.Final
- Tomcat - v2.5.6
- PostgreSQL - v12.9;
- Postman - v9.1.5



#### Instalação e Configuração

###### **1 - Clone do projeto:**

​	`$ git clone git@github.com:robertobernardes/desafio_inema.git`



###### **2 - Criação do banco de dados**

```sh
    CREATE DATABASE desafio_inema 
		WITH OWNER = postgres 
			ENCODING = 'UTF8' 
			TABLESPACE = pg_default 
			LC_COLLATE = 'pt_BR.UTF-8' 
			LC_CTYPE = 'pt_BR.UTF-8' 
			CONNECTION LIMIT = -1;
```



###### **3 - Criação da tabelas do banco**

###### 	**3.1 - Acessar a pasta `data` que esta dentro do projeto:**

​		`desafio_inema/data`

###### 	**3.2 - Abrir o arquivo `DDL.sql`, copiar e executar dentro do banco `desafio_inema` que foi criado no passo 2**

###### 	**3.3 - Abrir o arquivo `DML.sql`, copiar e executar dentro do banco `desafio_inema` que foi criado no passo 2**



###### **4 - Configuração da aplicação**

###### 	**4.1 - Acessar a pasta `resources` que está dentro do projeto:**

​		`desafio_inema/src/main/resources`

###### 	**4.2 - Abrir o arquivo `application.properties`** 

###### 		**4.2.1 - Na linha 4 - aonde se lê `localhost` substituir pelo seu servidor de banco de dados**

###### 		**4.2.2 - Na linha 6 - aonde se lê `123456` substituir pela sua senha do usuário `postgres` do banco de dados**



###### **5 - Utilizando a aplicação**

| Descrição                           | HTTP Verb |                         Endpoint |
| :---------------------------------- | :-------- | -------------------------------: |
| Consultar todas pessoas cadastradas | GET       |    http://localhost:8080/pessoas |
| Consultar uma pessoa cadastrada     | GET       | http://localhost:8080/pessoas/id |
| Cadastrar uma pessoa                | POST      |    http://localhost:8080/pessoas |
| Atualizar uma pessoa                | PUT       | http://localhost:8080/pessoas/id |
| Deletar uma pessoa                  | DELETE    | http://localhost:8080/pessoas/id |