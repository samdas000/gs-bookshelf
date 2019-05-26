
//Create new database for project PUNYA;
CREATE DATABASE PUNYA 

//Table to capture the information of Donors
//DROP TABLE DONOR IF EXISTS;

USE PUNYA;

CREATE TABLE DONOR 
(ID Bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
FIRST_NAME Varchar(20), 
LAST_NAME Varchar(20), 
EMAIL_ID Varchar(20), 
ADDRESS Varchar(50), 
LOCALITY Varchar(20), 
PINCODE Varchar(20), 
PHONE_NO Varchar(20), 
COUNTRY Varchar(20), 
CITY Varchar(20), 
LATITUDE Varchar(20), 
LONGITUDE Varchar(20));


CREATE TABLE BOOK 
(ID Bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
STREAM Varchar(50), 
STANDARD Varchar(50), 
SUBJECT Varchar(50), 
AUTHOR Varchar(50), 
TITLE Varchar(50), 
EDITION Varchar(20));

