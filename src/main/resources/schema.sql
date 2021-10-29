CREATE TABLE ADDRESSES
(
    id           INT PRIMARY KEY,
    landmark     VARCHAR(250),
    city         VARCHAR(250),
    street       VARCHAR(250),
    house_number INT,
    flat_number  INT
);

CREATE TABLE CLIENTS
(
    id          INT PRIMARY KEY,
    client_name VARCHAR(250),
    surname     VARCHAR(250),
    email       VARCHAR(250)
);

CREATE TABLE POSTS
(
    id          INT PRIMARY KEY,
    description VARCHAR(250),
    post_status VARCHAR(250)
);

INSERT INTO POSTS (id, description, post_status)
VALUES (1, 'Description is very good1', 'SENT'),
       (2, 'Description is very good2', 'ON_THE_WAY'),
       (3, 'Description is very good3', 'DELIVERED');

INSERT INTO CLIENTS (id, client_name, surname, email)
VALUES (1, 'Nurila', 'Zharkynbek', 'n@gmail.com'),
       (2, 'Assem', 'Meldebekova', 'a@gmail.com');

INSERT INTO ADDRESSES (id, landmark, city, street, house_number, flat_number)
VALUES (1, 'KZ', 'Almaty', 'Manas', 34, 606);


