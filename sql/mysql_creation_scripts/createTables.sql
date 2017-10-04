/* file to create user table in snaglog database */
USE snaglog;

/* remove the table if it exists */
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS log;
DROP TABLE IF EXISTS snag;

/* create the new table 'users' */
CREATE TABLE users (
  first_name CHAR(30) NOT NULL,
  last_name CHAR(30) NOT NULL,
  user_name CHAR(30) NOT NULL,
  user_pass CHAR(30) NOT NULL,
  PRIMARY KEY (user_name)
);

/* peek at the table */
DESC users;

/* create some test users */
INSERT INTO users (first_name, last_name, user_name, user_pass) VALUES ('Admin', 'Person', 'admin', 'admin');
INSERT INTO users (first_name, last_name, user_name, user_pass) VALUES ('Contributor', 'Person', 'contributorUser', 'contributor');
INSERT INTO users (first_name, last_name, user_name, user_pass) VALUES ('John', 'Carter', 'BigJohn', 'contributor');

/* use a 'select' to test if it worked */
SELECT * FROM users;


create table user_roles (
  user_name CHAR(30) not null,
  role_name CHAR(30) not null,
  primary key (user_name, role_name)
);

/* peek at the table */
DESC user_roles;

/* create some test roles for the previously added users */
INSERT INTO user_roles (user_name, role_name) VALUES ('admin', 'administrator');
INSERT INTO user_roles (user_name, role_name) VALUES ('contributorUser', 'contributor');
INSERT INTO user_roles (user_name, role_name) VALUES ('BigJohn', 'contributor');


/* use a 'select' to test if it worked */
SELECT * FROM user_roles;

CREATE TABLE log (
  log_id int NOT NULL AUTO_INCREMENT,
  user_name CHAR(30) NOT NULL,
  river_name CHAR(30) NOT NULL,
  state CHAR(2) NOT NULL,
  county CHAR(30),
  nearest_city CHAR(30),
  put_in_location VARCHAR(256),
  takeout_location VARCHAR(256),
  PRIMARY KEY (log_id)
);

DESC log;

INSERT INTO log (log_id, user_name, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, 'BigJohn', 'Yahara', 'WI', 'Dane', 'DeForest', 'Veterans Park, Deforest', 'Windsor Park, Windsor');
INSERT INTO log (log_id, user_name, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, 'contributorUser', 'Crayfish', 'WI', 'Jefferson', 'Lake Mills', 'County A Bridge, Milford, Wisconsin', 'Riverview Drive, Jefferson, Wisconsin');

/* use a 'select' to test if it worked */
SELECT * FROM log;

CREATE TABLE snag (
  snag_id int NOT NULL AUTO_INCREMENT,
  log_id int NOT NULL,
  location CHAR(30),
  type CHAR(30),
  blockage_amount CHAR(20),
  estimated_delay int,
  PRIMARY KEY (snag_id)
);

INSERT INTO snag (snag_id, log_id, location, type, blockage_amount, estimated_delay) VALUES (NULL, '1', 'gps coordinates', 'low water', 'total', '5');
INSERT INTO snag (snag_id, log_id, location, type, blockage_amount, estimated_delay) VALUES (NULL, '2', 'gps coordinates', 'tree fall', 'half', '1');

/* use a 'select' to test if it worked */
SELECT * FROM snag;

DESC snag;


