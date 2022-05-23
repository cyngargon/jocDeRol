DROP DATABASE IF EXISTS jocrol;
CREATE DATABASE jocrol;
USE jocrol;

CREATE TABLE if not exists DADES_PARTIDA (
id_partida INT AUTO_INCREMENT,
nom VARCHAR(3), 
puntuacio INT,
tempsJugat INT,
dataJoc datetime,
PRIMARY KEY (id_partida)
);

