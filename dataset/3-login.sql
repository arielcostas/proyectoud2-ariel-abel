DROP SCHEMA IF EXISTS proyectoud2_ariel_abel_login;
CREATE SCHEMA proyectoud2_ariel_abel_login;
USE proyectoud2_ariel_abel_login;
CREATE TABLE usuarios(
    username varchar(30) not null,
    password varchar(255) not null,
    primary key (username)
);

# La contraseña es 1234
INSERT INTO usuarios(username, password) VALUES ("admin", "$2a$12$ECkK0UVZdhEceFi1lz4zMOQHQJiAWND/3R9oernVMsURAyhuAVzzq"),
    ("jdbc", "$2a$12$ECkK0UVZdhEceFi1lz4zMOQHQJiAWND/3R9oernVMsURAyhuAVzzq");