/*
 --- INSTRUCCIONES PARA CORRER EL PROYECTO ---
 
 --- 1) EJECUTAR SOLAMENTE LA LINEA 10. 
 --- 2) LEVANTAR EL SERVIDOR EN SPRING.
 --- 3) EJECUTAR EL SCRIPT COMPLETO.

*/

create database if not exists `Grupo-10-BDD-OO2-2022`;

use `Grupo-10-BDD-OO2-2022`;


/*-------------------------------------- INSERTS --------------------------------------*/


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


LOCK TABLES `departamento` WRITE;
insert into departamento values(1, "Departamento de Desarrollo Productivo y Tecnologico");
UNLOCK TABLES;


LOCK TABLES `carrera` WRITE;
insert into carrera values(1, "Licenciatura en Sistemas", 1);
UNLOCK TABLES;


LOCK TABLES `profesor` WRITE;
insert into profesor values(1, "Alejandra", "Vranic");
insert into profesor values(2, "Gustavo", "Siciliano");
insert into profesor values(3, "Nicolas", "Perez");
insert into profesor values(4, "Alejandro", "Sasin");
insert into profesor values(5, "Federico", "Ribeiro");
UNLOCK TABLES;


LOCK TABLES `materia` WRITE;
insert into materia values(1, "Programacion orientada a objetos 2", 1);
insert into materia values(2, "Algoritmos y Estrucutras de Datos", 1);
insert into materia values(3, "Introduccion a las Bases de Datos", 1);
UNLOCK TABLES;


LOCK TABLES `edificio` WRITE;
insert into edificio values(1, "Jose Hernandez");
insert into edificio values(2, "Scalabrini Ortiz");
UNLOCK TABLES;


LOCK TABLES `aula` WRITE;
insert into aula values(1, 11, 1);
insert into aula values(2, 9, 1);
insert into aula values(3, 1, 2);
UNLOCK TABLES;


LOCK TABLES `laboratorio` WRITE;
insert into laboratorio values(80, 100, 1);
insert into laboratorio values(90, 95, 2);
UNLOCK TABLES;


LOCK TABLES `tradicional` WRITE;
insert into tradicional values(70, "tiza", false, 3);
UNLOCK TABLES;