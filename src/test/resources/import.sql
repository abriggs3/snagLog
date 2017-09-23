DROP TABLE IF EXISTS users;
CREATE TABLE users (first_name CHAR(30) NOT NULL, last_name CHAR(30) NOT NULL, user_name CHAR(30) NOT NULL, user_pass CHAR(30) NOT NULL, PRIMARY KEY (user_name));
INSERT INTO users (first_name, last_name, user_name, user_pass) VALUES ('Admin', 'Person', 'adminUser', 'admin');
INSERT INTO users (first_name, last_name, user_name, user_pass) VALUES ('Contributor', 'Person', 'contributorUser', 'contributor');
