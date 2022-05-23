DROP DATABASE IF EXISTS jocrol;
CREATE DATABASE jocrol;
USE jocrol;

CREATE TABLE if not exists DADES_PARTIDA (
id_partida INT AUTO_INCREMENT,
nom VARCHAR(3), 
puntuacio INT,
tempsJugat INT,
PRIMARY KEY (id_partida)
);

SELECT * FROM DADES_PARTIDA;