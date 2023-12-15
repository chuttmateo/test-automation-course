#5 alter table.
ALTER TABLE `zoo`.`animals`
ADD weight DOUBLE NOT NULL DEFAULT 0.0;

ALTER TABLE `zoo`.`events`
ADD `type` VARCHAR(25) NOT NULL;

ALTER TABLE `zoo`.`events`
DROP COLUMN `type`;

ALTER TABLE `zoo`.`animals`
MODIFY COLUMN weight INT;

ALTER TABLE `zoo`.`animals`
DROP COLUMN weight;
