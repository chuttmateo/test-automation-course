#10 statements for updating.
UPDATE `zoo`.`veterinarians`
SET `specialization` = 'Zoo Medicine'
WHERE `id` = 1;

UPDATE `zoo`.`animals`
SET `gender` = 'MALE'
WHERE `id` = 2;

UPDATE `zoo`.`animal_veterinarians`
SET `visit_day` = '2023-03-25 14:00:00'
WHERE `animals_id` = 3 AND `veterinarians_id` = 3;

UPDATE `zoo`.`enclosures`
SET `capacity` = `capacity` + 5
WHERE `id` = 1;

UPDATE `zoo`.`species`
SET `name` = 'Polar Bear'
WHERE `id` = 3;

UPDATE `zoo`.`employees`
SET `last_name` = 'Gonzalez'
WHERE `id` = 5;

UPDATE `zoo`.`employee_departments`
SET `department_id` = 4
WHERE `employee_id` = 2 AND `department_id` = 2;

UPDATE `zoo`.`veterinarians`
SET `last_name` = 'Williams'
WHERE `id` = 2;

UPDATE `zoo`.`enclosures`
SET `type` = 'AVIARY'
WHERE `id` = 3;

UPDATE `zoo`.`addresses`
SET `city` = 'San Francisco'
WHERE `id` = 2;

