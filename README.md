# spring-rest-api
Rest api em spring boot para controle de profissionais/horas trabalhadas em um projeto.

---
## Status

Status: **Em desenvolvimento.**

---
## Descrição
Nesse projeto, foram configuradas segurança com o spring security, e também autenticação por meio de JWT.
Também foi utilizado o banco de dados Mysql em um container Docker.

Para esta aplicação temos também a implementação de privilégios, aonde

* O admnistrador não pode apontar horas, mas pode ver as horas apontadas de todos desenvolvedores.
* O programador 1 pode apontar somente no projeto A.
* O programador 2 pode apontar nos projetos A e projeto B.

---
## Como rodar

Para rodar o projeto em sua máquina local, execute os seguintes comandos:

```bash
#Clone o projeto
git clone https://github.com/Guilherme-Sampaio/spring-rest-api.git

#Entre na pasta do projeto
cd spring-rest-api

#Instale as dependências
mvn clean install

#Monte a imagem do banco
docker build -t mysqlproject .

#Rode o banco e espere alguns segundos para ele subir.
docker run -d -p 3306:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=newproject -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin mysqlproject

#Rode o projeto
./mvnw spring-boot:run

```

Para realizar o login utilize algum dos seguintes usuários(**JSON**) na rota `/auth/signin`:

```JSON
{
  "username": "Admnistrador",
  "password": "adm123"
}
{
  "username": "Programador1",
  "password": "prog1123"
}
{
  "username": "Programador2",
  "password": "prog2123"
}
```

---
## Tecnologias usadas

* Spring-boot
* Docker
* Mysql

---
## Autor
Feito com carinho, café, e muita dedicação :) .

<a href="https://www.linkedin.com/in/guilherme-sampaio-4946a01a6/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAADAn1LABvmw2dWfN4Q51WAqXrKE4nrouSeU" target='_blank'>
<img style="border-radius: 50%;" src="https://media-exp3.licdn.com/dms/image/C4D03AQEoAQjPfuC4PA/profile-displayphoto-shrink_800_800/0/1602284719328?e=1631145600&v=beta&t=MpzKo6ddm6CttHKWjv647hEk8vOaxrkiLS2YUjt29z0" width="100px;" alt=""/>
</a>
</br>
<a href="https://www.linkedin.com/in/guilherme-sampaio-4946a01a6/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAADAn1LABvmw2dWfN4Q51WAqXrKE4nrouSeU" target='_blank'>
Guilherme Sampaio
</a>

[![Linkedin Badge](https://img.shields.io/badge/-Guilherme-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/guilherme-sampaio-4946a01a6/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAADAn1LABvmw2dWfN4Q51WAqXrKE4nrouSeU)](https://www.linkedin.com/in/guilherme-sampaio-4946a01a6/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAADAn1LABvmw2dWfN4Q51WAqXrKE4nrouSeU)
[![Gmail Badge](https://img.shields.io/badge/-kaisergui258@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:kaisergui258@gmail.com)](mailto:kaisergui258@gmail.com)
