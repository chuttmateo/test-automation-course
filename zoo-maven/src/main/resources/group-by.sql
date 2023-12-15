# 7 statements with aggregate functions and group by and without having.
SELECT gender FROM `zoo`.`animals` a
INNER JOIN `zoo`.`enclosures` e ON a.enclosure_id=e.id
GROUP BY gender;

SELECT `type`, sum(`capacity`) as 'Combined capacity' FROM `zoo`.`enclosures`
GROUP BY `type`;

SELECT `type`, min(`capacity`) as 'Min capacity' FROM `zoo`.`enclosures`
GROUP BY `type`;

SELECT `type`, avg(`capacity`) as 'AVG capacity' FROM `zoo`.`enclosures`
GROUP BY `type`;

SELECT `first_name` FROM `zoo`.`employees`
GROUP BY `first_name`;

SELECT `capacity`, COUNT(*) as 'Total by capacity' FROM `zoo`.`enclosures`
GROUP BY `capacity`;

SELECT a.city, count(*) FROM `zoo`.`employees` e
INNER JOIN `zoo`.`addresses` a ON e.address_id=a.id
GROUP BY a.city;

SELECT address_id, count(*) AS 'People by address ID' FROM `zoo`.`employees`
GROUP BY address_id;


# 7 statements with aggregate functions and group by and with having.
SELECT gender, count(*) FROM `zoo`.`animals` a
INNER JOIN `zoo`.`enclosures` e ON a.enclosure_id=e.id
GROUP BY gender
HAVING count(*) >= 3;

SELECT `type`, sum(`capacity`) as 'Combined capacity' FROM `zoo`.`enclosures`
GROUP BY `type`
HAVING sum(`capacity`) > 10;

SELECT `type`, min(`capacity`) as 'Min capacity' FROM `zoo`.`enclosures`
GROUP BY `type`
HAVING min(`capacity`) = 15;

SELECT `type`, avg(`capacity`) as 'AVG capacity' FROM `zoo`.`enclosures`
GROUP BY `type`
HAVING avg(`capacity`) > 10;


SELECT `capacity`, COUNT(*) as 'Total by capacity' FROM `zoo`.`enclosures`
GROUP BY `capacity`
HAVING COUNT(*) = 2;

SELECT a.city, count(*) FROM `zoo`.`employees` e
INNER JOIN `zoo`.`addresses` a ON e.address_id=a.id
GROUP BY a.city
HAVING a.city <> 'Buenos Aires';

SELECT address_id, count(*) AS 'People by address ID' FROM `zoo`.`employees`
GROUP BY address_id
HAVING address_id > 2;




