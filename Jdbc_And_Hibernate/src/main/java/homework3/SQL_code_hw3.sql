USE carsshop;

DROP TABLE IF EXISTS Animal;
DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE Animal(
id INT PRIMARY KEY,
name VARCHAR(15),
age INT,
tail BOOLEAN
);

CREATE TABLE hibernate_sequence(
next_val bigint
);
INSERT INTO hibernate_sequence  (next_val) VALUE (1);

SELECT * FROM hibernate_sequence;
SELECT * FROM Animal;
