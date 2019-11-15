
INSERT INTO public.role(id, role_name) VALUES (1,'ADMIN');
INSERT INTO public.role(id, role_name) VALUES (2,'MANAGER_BO');
INSERT INTO public.role(id, role_name) VALUES (3,'MANAGER');
INSERT INTO public.role(id, role_name) VALUES (4,'EVALUATOR');



INSERT INTO public.profile(id, profile_name,role_id) VALUES (1,'administrator',1);
INSERT INTO public.profile(id, profile_name,role_id) VALUES (2,'backOfficeManager',2);
INSERT INTO public.profile(id, profile_name,role_id) VALUES (3,'collaborater',3);

INSERT INTO public.profile(id, profile_name,role_id) VALUES (4,'evaluator',4);


INSERT INTO public.userr(
	mail, date_of_bithday, first_name, id, last_name, nationality, password, phone_number, profile_id)
	VALUES ('mouna.makni@yahoo.com','01-01-2001','mouna',1,'makni','tunisienne','$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy','4545454',3);
INSERT INTO public.userr(
	mail, date_of_bithday, first_name, id, last_name, nationality, password, phone_number, profile_id)
	VALUES ('ahmed.riahi@yahoo.com','01-01-2001','ahmed',2, 'riahi','tunisienne','$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy','4545454',3);

INSERT INTO public.userr(
	mail, date_of_bithday, first_name, id, last_name, nationality, password, phone_number, profile_id)
	VALUES ('ons.mahsni@yahoo.com','01-01-2001','ons',3,'mahsni','tunisienne','$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy','4545454',2);
INSERT INTO public.userr(
	mail, date_of_bithday, first_name, id, last_name, nationality, password, phone_number, profile_id)
	VALUES ('manef.manef@yahoo.com','01-01-2001','manef',4,'manef','tunisienne','$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy','4545454',1);

INSERT INTO public.userr(
	mail, date_of_bithday, first_name, id, last_name, nationality, password, phone_number, profile_id)
	VALUES ('yessine.mezrani@yahoo.com','01-01-2001','yessine',1,'mezrani','tunisienne','$2a$10$wgFYIddwOct5r.qfja/d3euh8fh6QG8IqsGOz8oAlut5lPSe4QCJK','4545454',4);


INSERT INTO public.university(
	university_name, id)
	VALUES ('ENSI',1);

INSERT INTO public.university(
	university_name, id)
	VALUES ('ENIT',2);
INSERT INTO public.university(
	university_name, id)
	VALUES ('FST',3);

INSERT INTO public.university(
	university_name, id)
	VALUES ('ESPRIT',4);

INSERT INTO public.university(
	university_name, id)
	VALUES ('ENICARTHAGE',5);

INSERT INTO public.university(
	university_name, id)
	VALUES ('ISET',6);

