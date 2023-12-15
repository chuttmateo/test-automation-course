#10 statements for insertion.
INSERT INTO `zoo`.`passports`
(`number`)
VALUES
("ms234"),("zv234"), ("ac223"), ("md234"), ("2233"),("mf4734"),("zp25634"), ("acb256723"), ("mda23234"), ("mnmfg2233"), ("mggdhs234"),("z45sv234"), ("ac2sf23"), ("md2sfg434"), ("22345s33");

INSERT INTO `zoo`.`addresses`
(`city`)
VALUES
("New York"), ("Los Angeles"), ("Buenos Aires"), ("Minsk"), ("Paris");

INSERT INTO `zoo`.`employees`
(`first_name`,
`last_name`,
`passport_id`,
`address_id`)
VALUES
("John", "Doe", 1, 1), 
("Marcos", "Juarex", 2, 2), 
("Matias", "Smith", 3, 4), 
("Marcus", "Johnson", 4, 4), 
("John", "Doe", 5, 5),
("Emma", "Brown", 6, 3), 
("Liam", "Garcia", 7, 2), 
("Sophia", "Martinez", 8, 1), 
("Oliver", "Anderson", 9, 5), 
("Ava", "Lopez", 10, 4),
("Noah", "Wang", 11, 2),
("Isabella", "Lee", 12, 3),
("William", "Nguyen", 13, 5),
("Mia", "Gonzalez", 14, 4),
("James", "Hernandez", 15, 1);

INSERT INTO `zoo`.`departments`
(`name`)
VALUES
("HR"), ("Sales"), ("Marketing"), ("Animal Medicine"), ("Animals");

INSERT INTO `zoo`.`employee_departments`
(`employee_id`,
`department_id`)
VALUES
(1, 1), (2, 2), (3, 2), (4, 5), (5, 5);

INSERT INTO `zoo`.`enclosures`
(`type`,
`capacity`,
`department_id`)
VALUES
("AQUARIUM", 10, 5), ("AVIARY", 10, 5), ("TERRARIUM", 20, 5), ("TERRARIUM", 15, 5);

INSERT INTO `zoo`.`species`
(`name`,
`habitat`,
`average_lifespan_in_years`)
VALUES
('Lion', 'Savannah', 12),
('Polar Bear', 'Arctic', 20),
('Elephant', 'Grasslands', 60),
('Tiger', 'Jungle', 15);

INSERT INTO `zoo`.`animals`
(`species`,
`enclosure_id`,
`species_id`,
`gender`)
VALUES
('Lion', 3, 1, 'MALE'),
('Elephant', 3, 3, 'FEMALE'),
('Tiger', 4, 4, 'MALE'),
('Polar Bear', 4, 2, 'FEMALE');

INSERT INTO `zoo`.`veterinarians`
(`specialization`,
`first_name`,
`last_name`)
VALUES
('Avian Medicine', 'Emily', 'Johnson'),
('Wildlife Medicine', 'Michael', 'Smith'),
('Zoo Animal', 'Sophia', 'Garcia');

INSERT INTO `zoo`.`animal_veterinarians`
(`animals_id`,
`veterinarians_id`,
`visit_day`,
`diagnosis`)
VALUES
(1, 1, '2023-01-15 09:30:00', 'Common cold'),
(2, 2, '2023-02-20 11:45:00', 'Injury treatment'),
(3, 3, '2023-03-10 13:20:00', 'Health checkup'),
(4, 1, '2023-04-05 10:00:00', 'Dental examination');

















