create table if not exists users (
	id SERIAL primary key,
	name varchar(100),
	email varchar(200),
	password varchar(50),
	role varchar(10)
);

insert into users (name, email, password, role) values ('admnistrador', 'admnistrador@gmail.com', 'adm123', 'ADMIN');
insert into users (name, email, password, role) values ('programador1', 'programador1@gmail.com', 'prog1123', 'PROG');
insert into users (name, email, password, role) values ('admnistrador', 'programador2@gmail.com', 'prog2123', 'PROG');

create table if not exists projects (
	id SERIAL primary key,
	name varchar(100),
	total_hours numeric
);

insert into projects (name, total_hours) values ('projectA', 0);
insert into projects (name, total_hours) values ('projectB', 0);

create table if not exists appointments (
	id SERIAL primary key,
	start_date date,
	finish_date date,
	user_id int references users(id),
	project_id int references projects(id)
);