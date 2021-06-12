DROP DATABASE IF EXISTS carShop;

CREATE DATABASE CarShop;

USE carShop;

CREATE TABLE clients
(
	 id INT AUTO_INCREMENT NOT NULL,
     name VARCHAR(30),
     age TINYINT,
     phone VARCHAR(15),
     PRIMARY KEY (id)
);

CREATE TABLE cars
(
	car_id int auto_increment,
	mark Varchar(20) NOT NULL,
	model Varchar(20) NULL,
	speed int NOT NULL,
	price int NOT NULL,
    primary key(car_id)
);


INSERT INTO cars (mark, model, speed, price) VALUES('BMW', '320d', 225, 36000);

INSERT INTO cars
(mark, model, speed, price)
VALUES
('Audi', 'A5', 250, 50000);

-------------------------------------------------------------------------
INSERT INTO cars
(mark, model, speed, price)
VALUES
('Porsche', '911', 285, 100000);
-------------------------------------------------------------------------

INSERT INTO cars (mark, model, speed, price) VALUES ('Audi', 'B3', 220, 55000);

INSERT INTO cars (mark, model, speed, price) VALUES ('BMW', 'B5', 240, 65000);

INSERT INTO cars (mark, model, speed, price) VALUES ('Porsche', '992', 320, 200000);

INSERT INTO cars (mark, model, speed, price) VALUES ('Porsche', 'taycan', 330, 250000);

INSERT INTO cars (mark, model, speed, price) VALUES ('Volga', '3000', 250, 80000);

------------------------------------------------------------------------------

insert into clients(name, age, phone) values('Dylan Faden', 21, '1313-13-03');
insert into clients(name, age, phone) values('Jessie Faden', 25, '1313-13-02');
insert into clients(name, age, phone) values('Kira Yoshikage', 33, '5543-33-68');
insert into clients(name, age, phone) values('Freddy Fazbear', 46, '9043-17-05');
insert into clients(name, age, phone) values('Grigory Chaos', 14, '6333-37-69');
insert into clients(name, age, phone) values('Dr. Alto Cleff', 67, '9857-88-86');

SELECT *  FROM cars;
SELECT * FROM clients;
