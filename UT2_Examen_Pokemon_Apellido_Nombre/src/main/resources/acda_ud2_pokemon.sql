-- ===========================================================
--  UT2_Examen_Pokemon
--  Script de creación e inserción de datos base
--  Base de datos: acda_ud2_pokemon
--  Autor: Profesor Oak
-- ===========================================================

-- 1️ CREACIÓN DE BASE DE DATOS
DROP DATABASE IF EXISTS ACDA_UT2;
CREATE DATABASE ACDA_UT2 CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE ACDA_UT2;

-- 2️ TABLA: PLATAFORMA
CREATE TABLE plataforma (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  fabricante VARCHAR(50) NOT NULL
);

-- 3️ TABLA: JUEGO_POKEMON
CREATE TABLE juego_pokemon (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  generacion INT,
  anio_lanzamiento INT,
  plataforma_id INT NOT NULL,
  CONSTRAINT fk_plataforma FOREIGN KEY (plataforma_id)
      REFERENCES plataforma(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- ===========================================================
--  INSERCIÓN DE DATOS BASE
-- ===========================================================

--  Plataformas principales
INSERT INTO plataforma (nombre, fabricante) VALUES
('Game Boy', 'Nintendo'),
('Game Boy Color', 'Nintendo'),
('Game Boy Advance', 'Nintendo'),
('Nintendo DS', 'Nintendo'),
('Nintendo 3DS', 'Nintendo'),
('Nintendo Switch', 'Nintendo');

-- ===========================================================
--  Generación 1 (1996–1999)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Rojo y Azul', 1, 1996, 1),
('Pokémon Amarillo', 1, 1998, 1);

-- ===========================================================
--  Generación 2 (1999–2002)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Oro y Plata', 2, 1999, 2),
('Pokémon Cristal', 2, 2000, 2);

-- ===========================================================
--  Generación 3 (2002–2006)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Rubí y Zafiro', 3, 2002, 3),
('Pokémon Esmeralda', 3, 2004, 3),
('Pokémon Rojo Fuego y Verde Hoja', 3, 2004, 3);

-- ===========================================================
--  Generación 4 (2006–2010)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Diamante y Perla', 4, 2006, 4),
('Pokémon Platino', 4, 2008, 4),
('Pokémon Oro HeartGold y Plata SoulSilver', 4, 2009, 4);

-- ===========================================================
--  Generación 5 (2010–2013)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Blanco y Negro', 5, 2010, 4),
('Pokémon Blanco 2 y Negro 2', 5, 2012, 4);

-- ===========================================================
--  Generación 6 (2013–2016)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon X y Y', 6, 2013, 5),
('Pokémon Rubí Omega y Zafiro Alfa', 6, 2014, 5);

-- ===========================================================
--  Generación 7 (2016–2019)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Sol y Luna', 7, 2016, 5),
('Pokémon Ultrasol y Ultraluna', 7, 2017, 5),
('Pokémon Let\'s Go Pikachu / Eevee', 7, 2018, 6);

-- ===========================================================
--  Generación 8 (2019–2022)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Espada y Escudo', 8, 2019, 6),
('Pokémon Diamante Brillante y Perla Reluciente', 8, 2021, 6),
('Leyendas Pokémon: Arceus', 8, 2022, 6);

-- ===========================================================
--  Generación 9 (2022–actualidad)
-- ===========================================================
INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id) VALUES
('Pokémon Escarlata', 9, 2022, 6),
('Pokémon Púrpura', 9, 2022, 6);

-- ===========================================================
--  FIN DEL SCRIPT
-- ===========================================================

SELECT COUNT(*) AS total_plataformas FROM plataforma;
SELECT COUNT(*) AS total_juegos FROM juego_pokemon;
