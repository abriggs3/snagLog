DROP TABLE IF EXISTS Snag;
DROP TABLE IF EXISTS Log;
DROP TABLE IF EXISTS User_roles;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (users_id int NOT NULL AUTO_INCREMENT, first_name CHAR(30) NOT NULL, last_name CHAR(30) NOT NULL, user_name CHAR(30) NOT NULL, user_pass CHAR(30) NOT NULL, PRIMARY KEY (users_id), UNIQUE (user_name));

INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL, 'Admin', 'Person', 'admin', 'admin');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL, 'Contributor', 'Person', 'contributorUser', 'contributor');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL,'John', 'Carter', 'BigJohn', 'contributor');
INSERT INTO Users (users_id, first_name, last_name, user_name, user_pass) VALUES (NULL,'Delete', 'Delete', 'Delete', 'Delete');

create table User_roles (user_roles_id int NOT NULL AUTO_INCREMENT, users_id int, user_name CHAR(30) not null, role_name CHAR(30) not null, PRIMARY KEY (user_roles_id), FOREIGN KEY (users_id) REFERENCES Users(users_id));

INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 1, 'admin', 'administrator');
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 2, 'contributorUser', 'contributor');
INSERT INTO User_roles (user_roles_id, users_id, user_name, role_name) VALUES (NULL, 3, 'BigJohn', 'contributor');

CREATE TABLE Log (log_id int NOT NULL AUTO_INCREMENT, users_id int NOT NULL, river_name CHAR(30) NOT NULL, state CHAR(2) NOT NULL, county CHAR(30), nearest_city CHAR(30), put_in_location VARCHAR(256), takeout_location VARCHAR(256), PRIMARY KEY (log_id), FOREIGN KEY (users_id) REFERENCES Users(users_id));

INSERT INTO Log (log_id, users_id, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, '2', 'Yahara', 'WI', 'Dane', 'DeForest', 'Veterans Park, Deforest', 'Windsor Park, Windsor');
INSERT INTO Log (log_id, users_id, river_name, state, county, nearest_city, put_in_location, takeout_location) VALUES (NULL, '3', 'Crayfish', 'WI', 'Jefferson', 'Lake Mills', 'County A Bridge, Milford, Wisconsin', 'Riverview Drive, Jefferson, Wisconsin');

CREATE TABLE Snag (snag_id int NOT NULL AUTO_INCREMENT, log_id int NOT NULL, location CHAR(30), type CHAR(30), blockage_amount CHAR(20), estimated_delay int, PRIMARY KEY (snag_id), FOREIGN KEY (log_id) REFERENCES Log(log_id));

INSERT INTO Snag (snag_id, log_id, location, type, blockage_amount, estimated_delay) VALUES (NULL, '1', 'gps coordinates', 'low water', 'total', '5');
INSERT INTO Snag (snag_id, log_id, location, type, blockage_amount, estimated_delay) VALUES (NULL, '2', 'gps coordinates', 'tree fall', 'half', '1');