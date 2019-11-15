sql:
CREATE TABLE moussaillonJDBC.bateau(
id int NOT NULL,
name CHAR(80) NOT NULL,
type CHAR(80) NOT NULL,
size float NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE moussaillonJDBC.moussaillon(
id int NOT NULL,
first_name CHAR(80) NOT NULL,
last_name CHAR(80) NOT NULL,
config CHAR(80) NOT NULL,
bateau_id INTEGER NOT NULL,
PRIMARY KEY(id),
CONSTRAINT FK_BateauMoussaillon FOREIGN KEY (bateau_id)
 REFERENCES moussaillonJDBC.bateau(id)
);

CREATE TABLE moussaillonJDBC.port(
id SERIAL NOT NULL,
name CHAR(30) NOT NULL,
pays CHAR(80) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE moussaillonjdbc.grade(
id SERIAL NOT NULL,
name CHAR(30) NOT NULL,
description CHAR(80) NOT NULL,
PRIMARY KEY(id)
);

ALTER TABLE moussaillonJDBC.moussaillon
   ADD grade_id INTEGER NOT NULL,
   ADD CONSTRAINT FK_grade FOREIGN KEY(grade_id) REFERENCES moussaillonJDBC.grade(id);

ALTER TABLE moussaillonJDBC.bateau
   ADD port_id INTEGER NULL,
   ADD CONSTRAINT FK_port FOREIGN KEY(port_id) REFERENCES moussaillonJDBC.port(id);
    
INSERT INTO moussaillonjdbc.grade(
    name, description)
    VALUES ('Capitaine', 'Capitaine Description');
INSERT INTO moussaillonjdbc.grade(
    name, description)
    VALUES ('Second', 'Second Description');
INSERT INTO moussaillonjdbc.grade(
    name, description)
    VALUES ( 'Canonnier', 'Canonnier Description');
INSERT INTO moussaillonjdbc.grade(
    name, description)
    VALUES ('Maitre-Equipage', 'Maitre-Equipage Description');