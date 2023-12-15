# 1 big statement to join all tables in the database
SELECT 
e.first_name as 'First Name',
e.last_name as 'Last Name',
p.`number` as 'Passport Number',
a.city as 'City',
d.`name` as 'Department name',
en.`type` as 'Enclosure Type'
FROM employees e
INNER JOIN passports p ON e.passport_id = p.id
INNER JOIN addresses a ON e.address_id = a.id
INNER JOIN employee_departments ed ON e.id = ed.employee_id
INNER JOIN departments d ON ed.department_id = d.id
LEFT JOIN enclosures en ON d.id = en.department_id;

# 5 statements with left, right, inner, outer joins.
Use zoo;

SELECT * FROM `zoo`.`employees` e
LEFT JOIN `zoo`.`passports` p ON e.passport_id=p.id;

SELECT * FROM `zoo`.`employees` e
INNER JOIN `zoo`.`addresses` a ON e.address_id=a.id;

SELECT * FROM `zoo`.`employees` e 
INNER JOIN `zoo`.`employee_departments` ed ON e.id=ed.employee_id
RIGHT JOIN `zoo`.`departments` d ON ed.department_id=d.id;

SELECT * FROM `zoo`.`animals` a
INNER JOIN `zoo`.`enclosures` e ON a.enclosure_id=e.id;


