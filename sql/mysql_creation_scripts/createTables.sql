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
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL, 'Bat', 'Man', 'batman', 'batman');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL,'Super', 'Man', 'superman', 'superman');

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
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 2, 'batman', 'contributor');
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 3, 'superman', 'contributor');



/* use a 'select' to test if it worked */
SELECT * FROM User_roles;

CREATE TABLE Log (
  log_id int NOT NULL AUTO_INCREMENT,
  users_id int NOT NULL,
  launchDate DATE,
  tripDuration INT,
  startLocationLat DECIMAL(10, 8),
  startLocationLon DECIMAL(11, 8),
  endLocationLat DECIMAL(10, 8),
  endLocationLon DECIMAL(11, 8),
  waterBodyName CHAR(30),
  waterBodyType CHAR(30),
  waterSubChoice CHAR(30),
  logText TEXT,
  city CHAR(30),
  state CHAR(30),
  weatherDescription CHAR(255),
  temperature DECIMAL(5, 3),
  PRIMARY KEY (log_id),
  FOREIGN KEY (users_id) REFERENCES Users(users_id)
);

DESC Log;

INSERT INTO Log (log_id, users_id, launchDate, tripDuration, startLocationLat, startLocationLon, endLocationLat, endLocationLon, waterBodyName, waterBodyType, waterSubChoice, logText, city, state, weatherDescription, temperature) VALUES (NULL, '2', '2017-12-15', '4', '43.12', '-89.32', '43.14', '88.35','Yahara', 'flat water', 'small river', 'Nice in high water, otherwise boat will drag.', 'Deforest', 'WI', 'cloudy', 45);
INSERT INTO Log (log_id, users_id, launchDate, tripDuration, startLocationLat, startLocationLon, endLocationLat, endLocationLon, waterBodyName, waterBodyType, waterSubChoice, logText, city, state, weatherDescription, temperature) VALUES (NULL, '3', '2017-01-03', '6', '48.12', '-90.33', '47.33', '-88.35', 'Crayfish', 'flat water', 'small river', 'Easy paddle on round for out and back.', 'Jefferson', 'WI', 'sunny', 82);


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


