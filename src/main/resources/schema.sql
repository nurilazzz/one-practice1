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


