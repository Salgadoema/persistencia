DROP SCHEMA IF EXISTS bichomones;
CREATE SCHEMA bichomones;
USE bichomones;

CREATE TABLE especie (
  id int NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL UNIQUE,
  peso int NOT NULL,
  altura int NOT NULL,
  energia_inicial int NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  url_foto VARCHAR(255),
  cantidad_de_bichos int NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB;