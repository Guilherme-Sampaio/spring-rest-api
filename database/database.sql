CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(100),
	email VARCHAR(200),
	password VARCHAR(200),
	PRIMARY KEY(id)
);

INSERT INTO users (username, email, password) VALUES ('admnistrador', 'admnistrador@gmail.com', '$2a$10$NGRi1LpS.MtE/oakqlwxd./iILhgTGmgHUTo7Q7OMh.YM4RpXYzia');
INSERT INTO users (username, email, password) VALUES ('programador1', 'programador1@gmail.com', '$2a$10$PF5jSZKo1UjvStBif99zXuzJpEVcXd7zMVyfC/HeuBVHme778z.IW');
INSERT INTO users (username, email, password) VALUES ('programador2', 'programador2@gmail.com', '$2a$10$1t.VEpbRN.l1nIB.eKPnWelx/hKN9Iz1gaciP5t5/ZoqI/ZEywMWK');

CREATE TABLE IF NOT EXISTS roles (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	PRIMARY KEY(id)
);

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_DEV');

CREATE TABLE IF NOT EXISTS user_role (
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY(user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);

CREATE TABLE IF NOT EXISTS projects (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	PRIMARY KEY(id)
);

INSERT INTO projects (name) VALUES ('projectA');
INSERT INTO projects (name) VALUES ('projectB');

CREATE TABLE IF NOT EXISTS user_in_project (
    user_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY(user_id, project_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (project_id) REFERENCES projects(id)
);

INSERT INTO user_in_project (user_id, project_id) VALUES (1, 1);
INSERT INTO user_in_project (user_id, project_id) VALUES (2, 1);
INSERT INTO user_in_project (user_id, project_id) VALUES (2, 2);

CREATE TABLE IF NOT EXISTS appointments (
	id INT NOT NULL AUTO_INCREMENT,
	start_date DATETIME,
	finish_date DATETIME,
	user_id INT,
	project_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (project_id) REFERENCES projects(id)
);