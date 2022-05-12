drop database if exists `Grupo-10-BDD-OO2-2022`;
create database if not exists `Grupo-10-BDD-OO2-2022`;
use `Grupo-10-BDD-OO2-2022`;


CREATE TABLE `perfil`(
  `id_perfil` int NOT NULL AUTO_INCREMENT,
  `tipo_perfil` varchar(255) NOT NULL,
  `activo` bit(1) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`),
  UNIQUE KEY `UK_3b0dloqo94v7r6tjahpid9hc3` (`tipo_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `dni` bigint(8) NOT NULL,
  `email` varchar(60) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `clave` varchar(60) NOT NULL,
  `activo` bit(1) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `id_perfil` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`),
  KEY `FK131gkl0dt1966rsw6dmesnsxw` (`id_perfil`, `dni`),
  CONSTRAINT `FK131gkl0dt1966rsw6dmesnsxw` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `perfil` WRITE;
INSERT INTO perfil (id_perfil, tipo_perfil, activo, createdat, updatedat) VALUES( 1, "administrador", true, now(), now() );

INSERT INTO perfil (id_perfil, tipo_perfil, activo, createdat, updatedat) VALUES( 2, "auditoria", true, now(), now() );
UNLOCK TABLES;


LOCK TABLES `usuario` WRITE;
INSERT INTO usuario (id_usuario, nombre, apellido, dni, email, nombre_usuario, clave, activo, createdat, updatedat, id_perfil)
VALUES(1, "Administrador", "Administrador", 00000000, "admin@gmail.com", "admin", "$2a$10$glvtPMbUNyNMoaa6SF9hWOYwPt.hDt.cHs/bJagJ9Kaf3Shpt2co6", true, now(), now(), 1);

INSERT INTO usuario (id_usuario, nombre, apellido, dni, email, nombre_usuario, clave, activo, createdat, updatedat, id_perfil) 
VALUES(2, "Auditoria", "Auditoria", 11111111, "Auditoria@gmail.com", "auditor", "$2a$10$t6McDb.aIokbKk6RkdCe2eiHn0xCpbi8w01bYlyQ3VGjIXzfdC7Ru", true, now(), now(), 2);
UNLOCK TABLES;
