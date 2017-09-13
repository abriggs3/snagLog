/* file to create user table in snaglog database */
USE snaglog;

/* remove the table if it exists */
DROP TABLE IF EXISTS users;

/* create the new table */
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  firstName CHAR(30) NOT NULL,
  lastName CHAR(30) NOT NULL,
  userName CHAR(30) NOT NULL,
  role CHAR(30) NOT NULL,
  password CHAR(30) NOT NULL,
  PRIMARY KEY (id)
);

/* peek at the table */
DESC users;

/* create some test users */
INSERT INTO users (firstName, lastName, userName, role, password) VALUES ('Admin', 'Person', 'adminUser', 'admin', 'admin');
INSERT INTO users (firstName, lastName, userName, role, password) VALUES ('Contributor', 'Person', 'contributorUser', 'contributor', 'contributor');

/* use a 'select' to test if it worked */
SELECT * FROM users;
