
insert into client (name) values ('Tymothy Becker'),
('Alan Wood'), ('Tobby Stick'), ('Martin Schommer'),
('Angela Shelby'), ('Max Hoffer'), ('Anthony Santos'),
('Roman Green'), ('Benedict Lisovskii'), ('Fabien Doll');

insert into planet (id, name) values ('EA3','Earth'), ('TM210','TutrleMutant'),
('VEN2','Venus'), ('JUP','Jupiter'), ('Y7435','Y7435');

insert into ticket (client_id, from_planet_id, to_planet_id) values (3,'EA3','JUP'),
(1,'VEN2','TM210'), (7,'EA3','JUP'), (8,'TM210','Y7435'), (4,'Y7435','EA3'), (6,'EA3','JUP'),
(2,'EA3','VEN2'), (5,'EA3','Y7435'), (9,'EA3','TM210'), (3,'JUP','VEN2');

