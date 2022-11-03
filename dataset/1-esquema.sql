DROP SCHEMA IF EXISTS proyectoud2_ariel_abel;
CREATE SCHEMA proyectoud2_ariel_abel;
USE proyectoud2_ariel_abel;

CREATE TABLE artistas(
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    leadStreams BIGINT NOT NULL,
    feats BIGINT NOT NULL,
    tracks INT NOT NULL,
    oneBillion INT NOT NULL,
    hundredMillion INT NOT NULL,
    lastUpdated date NOT NULL,
    PRIMARY KEY (id)
);