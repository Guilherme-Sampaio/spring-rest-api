FROM mysql:latest

COPY ./database/ /docker-entrypoint-initdb.d/


