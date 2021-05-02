select * from dog;

SELECT id, kind, price, image, country, height, weight, content, readcount
FROM   dog;

SELECT id, kind, price, image, country, height, weight, content, readcount
FROM   dog
 where id = 1;

INSERT INTO dog (kind, price, image, country, height, weight, content) VALUES
('푸들'  , 1000, 'pu.jpg' , '프랑스' , 1, 20, '털 많다');;