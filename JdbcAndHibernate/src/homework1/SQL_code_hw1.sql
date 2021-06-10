DROP DATABASE IF EXISTS MyJoinsDB;
Create DATABASE MyJoinsDB;
USE MyJoinsDB;

DROP TABLE IF EXISTS NamesAndNumbers;

CREATE TABLE NamesAndNumbers(
NAME TEXT,
PHONES TEXT
);

DROP TABLE IF EXISTS PostAndSalary;

CREATE TABLE PostAndSalary(
NAME TEXT,
POST TEXT,
SALARY INT
);

DROP TABLE IF EXISTS family;

CREATE TABLE family(
NAME TEXT,
City TEXT,
Birthday TEXT,
Married_status TEXT
);


INSERT INTO NamesAndNumbers (NAME, PHONES) VALUES  ("Kira Yoshikage", "5343234899"), ("Grisha Joestar", "2341566644"), ("Joyine Kujo", "7123666344"), ("Jack Bright", "0000000001"), ("Haosit Chaotov", "2232712132");

INSERT INTO PostAndSalary (NAME, POST, SALARY) VALUES ("Kira Yoshikage", "Chief director", 500000), ("Grisha Joestar", "Manager", 80000), ("Joyine Kujo", "Manager", 70000), ("Jack Bright", "Worker", 6000), ("Haosit Chaotov", "Worker", 5000);

INSERT INTO family (NAME, City, Birthday, Married_status) VALUES ("Kira Yoshikage", "Morioh", "29 Oct", "Alone"), ("Grisha Joestar", "Donetsk", "29 Dec", "Married"), ("Joyine Kujo", "Tokio", "10 Mar", "Married"), ("Jack Bright", "Boco Chiko", "20 Sep", "Married"), ("Haosit Chaotov", "Kiev", "03 Jan", "Alone");

SELECT * FROM NamesAndNumbers;
SELECT * FROM PostAndSalary;
SELECT * FROM family;