Script sql
CREATE TABLE role(
id int NOT NULL,
nom CHAR(30) NOT NULL,
PRIMARY KEY(id)
);
INSERT INTO role VALUES (1, 'CLIENT');
CREATE TABLE userr(
id SERIAL NOT NULL,
firstname CHAR(80) NOT NULL,
name CHAR(80) NOT NULL,
pseudo CHAR(80) NOT NULL,
mail CHAR(80) NOT NULL,
u_password CHAR(80) NOT NULL,
phone CHAR(14) NOT NULL,
address CHAR(80) NOT NULL,
role_id int NOT NULL,
PRIMARY KEY(id),
CONSTRAINT FK_RoleUser FOREIGN KEY (role_id)
REFERENCES role(id)
);
INSERT INTO userr (firstname, name, pseudo, mail, u_password, phone, address, role_id) VALUES ( 'Pirate', 'Carabes', 'Johny', 'johnyPirate@Cara.com', 'unmotdepassedepirate', '1563214560', 'Entre latlantic et le pacific.',1);
INSERT INTO userr (firstname, name, pseudo, mail, u_password, phone, address, role_id) VALUES ('Corsaire', 'THP', 'George', 'george@Cara.com', 'unmotdepassedecorsaire', '1563214561', 'Entre la manche et la mer du nord.',1);
INSERT INTO userr (firstname, name, pseudo, mail, u_password, phone, address, role_id) VALUES  ('Moussaillon', 'Java', 'Coding', 'coding@Cara.com', 'unmotdepassedemoussaillon', '1563214562', 'Sur la mditrrane.',1);
CREATE TABLE category(
id int NOT NULL,
name CHAR(30) NOT NULL,
description VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);
INSERT INTO category VALUES (1, 'T-SHIRT', 'Vtement lger souvent mis lt.');
INSERT INTO category VALUES (2, 'Pantalon', 'Vtement du bas du corp mis pour couvrir ses jambres.');
INSERT INTO category VALUES (3, 'Veste', 'Vtement chaud.');
CREATE TABLE announcement(
id SERIAL NOT NULL,
title CHAR(50) NOT NULL,
description VARCHAR(750) NOT NULL,
category_id int NOT NULL,
price float NOT NULL,
picture CHAR(100) NULL,
publication_date DATE NOT NULL,
is_available boolean NOT NULL,
view_number int NOT NULL,
localisation CHAR(100),
user_id int NOT NULL,
PRIMARY KEY(id),
CONSTRAINT FK_UserAnnouncement FOREIGN KEY (user_id)
REFERENCES userr(id),
CONSTRAINT FK_CategoryAnnouncement FOREIGN KEY (category_id)
REFERENCES category(id)
);
INSERT INTO announcement (title, description, category_id, price, picture,publication_Date, is_available,  view_number, localisation, user_id) VALUES ('t-shirt lacuste bon tat', 'Je vends mon magnifique t-shirt lacuste achet lanne dernire en solde, taille M.',1,24.98,NULL,'2019-01-25 8:32:12', true, 2,'Paris 9ime',1);
INSERT INTO announcement (title, description, category_id, price, picture,publication_Date, is_available,  view_number, localisation, user_id) VALUES ('Veste Guoss comme nueve', 'Je vends ma sublime veste Guoss achete cette anne en solde, taille S.',3,87.25,NULL,'2019-02-25 11:32:12', true, 8,'Paris 9ime',2);
CREATE TABLE favoris(
id SERIAL NOT NULL,
id_user int NOT NULL,
id_announcement int NOT Null,
dateOfAdd DATE NOT NULL,
PRIMARY KEY(id),
CONSTRAINT FK_UserFavoris FOREIGN KEY (id_user)
REFERENCES userr(id),
CONSTRAINT FK_FavoritAnnouncement FOREIGN KEY (id_announcement)
REFERENCES announcement(id)
);