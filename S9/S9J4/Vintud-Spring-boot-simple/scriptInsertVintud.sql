/* Add Roles */
INSERT INTO public.role(name) VALUES ('CLIENT');
INSERT INTO public.role(name) VALUES ('MODERATEUR');
INSERT INTO public.role(name) VALUES ('ADMIN');

/* Add Users */
INSERT INTO public.userr(firstname, name, pseudo, mail, userPassword, phone, address, roleId)
	VALUES ('Pirate', 'CaraÃ¯bes', 'Johny', 'johnyPirate@Cara.com', 'unmotdepassedepirate', '1563214560', 'Entre latlantic et le pacific.',1);
INSERT INTO public.userr(firstname, name, pseudo, mail, userPassword, phone, address, roleId)
	VALUES ('Corsaire', 'THP', 'George', 'george@Cara.com', 'unmotdepassedecorsaire', '1563214561', 'Entre la manche et la mer du nord.',1);
INSERT INTO public.userr(firstname, name, pseudo, mail, userPassword, phone, address, roleId)
	VALUES ('Moussaillon', 'Java', 'Coding', 'coding@Cara.com', 'unmotdepassedemoussaillon', '1563214562', 'Sur la mÃ©ditÃ©rranÃ©e.',1);


/* Add Categories */
INSERT INTO public.category(name, description) VALUES ('T-SHIRT', 'VÃªtement lÃ©ger souvent mis lÃ©tÃ©.');
INSERT INTO public.category(name, description) VALUES ('Pantalon', 'VÃªtement du bas du corp mis pour couvrir ses jambres.');
INSERT INTO public.category(name, description) VALUES ('Veste', 'VÃªtement chaud.');

/* add announcements */

INSERT INTO public.announcement(title, description, categoryId, price, photo, datePublication, isAvailable, nbrViews, location, userId)
	VALUES ('t-shirt lacuste bon Ã©tat', 'Je vends mon magnifique t-shirt lacuste achetÃ© lannÃ©e derniÃ¨re en solde, taille M.',1,24.98,NULL,'2019-01-25 8:32:12', true, 2,'Paris 9iÃ¨me',1);
INSERT INTO public.announcement(title, description, categoryId, price, photo, datePublication, isAvailable, nbrViews, location, userId)
 VALUES ('Veste Guoss comme nueve', 'Je vends ma sublime veste Guoss achetÃ©e cette annÃ©e en solde, taille S.',3,87.25,NULL,'2019-02-25 11:32:12', true, 8,'Paris 9iÃ¨me',2); 