CREATE TABLE ADDRESSES
(
    id           INT PRIMARY KEY,
    landmark     VARCHAR(250),
    city         VARCHAR(250),
    house_number INT
);

CREATE TABLE CLIENTS
(
    id          INT PRIMARY KEY,
    email       VARCHAR(250)
);

CREATE TABLE POSTS
(
    id          INT PRIMARY KEY,
    post_name   VARCHAR(250),
    description VARCHAR(250),
    post_status VARCHAR(250)
);


