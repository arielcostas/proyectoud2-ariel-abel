CREATE USER usuario_login IDENTIFIED BY '7WQzdXsv';
GRANT SELECT ON proyectoud2_ariel_abel_login.* TO usuario_login;

CREATE USER usuario_artistas IDENTIFIED BY 'yYTng2wg';
GRANT SELECT, INSERT, UPDATE, DELETE ON proyectoud2_ariel_abel.* TO usuario_artistas;
