CREATE DATABASE db_myresto;

USE db_myresto;

CREATE TABLE account(
  name varchar(50) NOT NULL,
  gender varchar(16) NOT NULL,
  job varchar(50) NOT NULL,
  username varchar(16) NOT NULL PRIMARY KEY,
  email varchar(50) NOT NULL,
  password varchar(8) NOT NULL,
  foto varchar(255)
);

INSERT INTO account(`name`, `gender`, `job`, `username`, `email`, `password`)
VALUES
('Muhammad Fadhillah Nursyawal', 'Male', 'Admin', 'admin', 'fadilahnursyawal@upi.edu', 'admin');

SELECT * FROM account;

CREATE TABLE foods(
  id_food int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  price int(20) NOT NULL,
  description TEXT(999)
);

INSERT INTO foods(`name`, `price`, `description`) 
VALUES
('Steak', 250000, 'Daging sapi panggang dengan saus black pepper dan kentang goreng'),
('Pasta Carbonara', 150000, 'Pasta dengan saus creamy dari telur, keju parmesan, dan smoked beef'),
('Grilled Chicken', 120000, 'Ayam bakar dengan bumbu rempah dan nasi putih'),
('Fish and Chips', 100000, 'Ikan goreng tepung dengan kentang goreng dan saus tartar'),
('Caesar Salad', 80000, 'Sayur romaine, crouton, keju parmesan, dan saus caesar'),
('Burger', 120000, 'Roti, patty sapi, keju, selada, tomat, dan saus burger'),
('Fried Rice', 90000, 'Nasi goreng dengan telur, ayam, dan sayuran'),
('Pizza Margherita', 180000, 'Pizza dengan saus tomat, keju mozzarella, dan basil'),
('Beef Rendang', 200000, 'Daging sapi yang dimasak dengan bumbu rempah khas Indonesia'),
('Sushi Roll', 150000, 'Nori, nasi, dan isian seperti salmon, avokad, dan mentimun');

SELECT * FROM foods;

CREATE TABLE drinks(
  id_drink int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  price int(20) NOT NULL,
  description TEXT(999)
);

INSERT INTO drinks(name, price, description) 
VALUES
("Iced Caramel Macchiato", 25000, "Espresso shot dituangkan di atas susu dan sirup karamel yang disajikan dingin"),
("Matcha Latte", 28000, "Minuman berbasis matcha dengan campuran susu, gula dan whipped cream"),
("Chocolate Frappuccino", 30000, "Espresso dicampur dengan susu cokelat, sirup vanila, dan disajikan dingin dengan whipped cream di atasnya"),
("Hazelnut Latte", 27000, "Espresso dicampur dengan susu dan sirup hazelnut, kemudian dihiasi dengan whipped cream"),
("Mango Smoothie", 32000, "Smoothie dengan campuran mangga, yogurt, susu, dan es batu"),
("Avocado Milkshake", 35000, "Minuman segar yang terbuat dari daging buah alpukat yang diblender dengan susu dan gula"),
("Iced Green Tea", 23000, "Teh hijau yang disajikan dingin dengan sirup gula dan es batu"),
("Cinnamon Hot Chocolate", 26000, "Susu cokelat yang dicampur dengan bubuk kayu manis"),
("Caramel Affogato", 32000, "Es krim vanila yang disiram dengan espresso shot dan sirup karamel"),
("Iced Vanilla Latte", 25000, "Espresso yang dicampur dengan susu dan sirup vanila, kemudian disajikan dingin");

SELECT * FROM drinks;

ALTER TABLE foods ADD COLUMN image varchar(255);
ALTER TABLE drinks ADD COLUMN image varchar(255);