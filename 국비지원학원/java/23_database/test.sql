-- 드래그후 alt + x , alt + c
CREATE USER smart@'%' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON *.* TO smart@'%'
WITH GRANT OPTION;

SHOW GRANTS FOR smart@'%';

flush PRIVILEGES;
