/* file to create user table in snaglog database */
USE snaglog;

/* remove the table if it exists */
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Snag;
DROP TABLE IF EXISTS Log;
DROP TABLE IF EXISTS User_roles;
DROP TABLE IF EXISTS Users;
SET foreign_key_checks = 1;

/* create the new table 'users' */
CREATE TABLE Users (
  users_id int NOT NULL AUTO_INCREMENT,
  first_name CHAR(30) NOT NULL,
  last_name CHAR(30) NOT NULL,
  user_name CHAR(30) NOT NULL,
  user_pass CHAR(30) NOT NULL,
  PRIMARY KEY (users_id),
  UNIQUE (user_name)
);

/* peek at the table */
DESC Users;

/* create some test users */
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL, 'Admin', 'Person', 'admin', 'admin');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL, 'Contributor', 'Person', 'contributorUser', 'contributor');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL,'John', 'Carter', 'BigJohn', 'contributor');

/* use a 'select' to test if it worked */
SELECT * FROM Users;


create table User_roles (
  user_roles_id int NOT NULL AUTO_INCREMENT,
  users_id int,
  user_name CHAR(30) not null,
  role_name CHAR(30) not null,
  PRIMARY KEY (user_roles_id),
  FOREIGN KEY (users_id) REFERENCES Users(users_id)
);

/* peek at the table */
DESC User_roles;

/* create some test roles for the previously added users */
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 1, 'admin', 'administrator');
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 2, 'contributorUser', 'contributor');
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 3, 'BigJohn', 'contributor');


/* use a 'select' to test if it worked */
SELECT * FROM User_roles;

CREATE TABLE Log (
  log_id int NOT NULL AUTO_INCREMENT,
  users_id int NOT NULL,
  river_name CHAR(30) NOT NULL,
  state CHAR(2) NOT NULL,
  county CHAR(30),
  nearest_city CHAR(30),
  put_in_location VARCHAR(256),
  takeout_location VARCHAR(256),
  PRIMARY KEY (log_id),
  FOREIGN KEY (users_id) REFERENCES Users(users_id)
);

DESC Log;

INSERT INTO Log (log_id, users_id, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, '2', 'Yahara', 'WI', 'Dane', 'DeForest', 'Veterans Park, Deforest', 'Windsor Park, Windsor');
INSERT INTO Log (log_id, users_id, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, '3', 'Crayfish', 'WI', 'Jefferson', 'Lake Mills', 'County A Bridge, Milford, Wisconsin', 'Riverview Drive, Jefferson, Wisconsin');

/* use a 'select' to test if it worked */
SELECT * FROM Log;

CREATE TABLE Snag (
  snag_id int NOT NULL AUTO_INCREMENT,
  users_id int NOT NULL,
  locationLat DECIMAL(10, 8) NOT NULL,
  locationLon DECIMAL(11, 8) NOT NULL,
  blockage_type VARCHAR(30) NOT NULL,
  hazard VARCHAR(20) NOT NULL,
  estimated_delay int NOT NULL,
  additional_desc TEXT NOT NULL,
  date TIMESTAMP NOT NULL,
  cleared TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (snag_id),
  FOREIGN KEY (users_id) REFERENCES Users(users_id)
);

INSERT INTO Snag (snag_id, users_id, locationLat, locationLon, blockage_type, hazard, estimated_delay, additional_desc, date, cleared) VALUES (NULL, '1', 43.206177, -89.840698, 'low water', 'annoying', 5, 'Wisconsin River near Baraboo, low water', NULL, DEFAULT);
INSERT INTO Snag (snag_id, users_id, locationLat, locationLon, blockage_type, hazard, estimated_delay, additional_desc, date, cleared) VALUES (NULL, '1', 44.806177, -88.740698, 'tree fall', 'mild', 15, 'Yahara River near Deforest, total block, must portage', NULL, DEFAULT);

/* use a 'select' to test if it worked */
SELECT * FROM Snag;

DESC Snag;


