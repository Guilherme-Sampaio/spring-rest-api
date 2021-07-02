#!/bin/bash
docker build -t mysqlproject .

docker run -d -p 3306:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=newproject -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin mysqlproject