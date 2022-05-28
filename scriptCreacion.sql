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
insert into profesor values(6, "Hernan", "Amatriain");
UNLOCK TABLES;


LOCK TABLES `materia` WRITE;
insert into materia values(1, "8616", "Programacion orientada a objetos 2", 1);
insert into materia values(2, "8609","Algoritmos y Estrucutras de Datos", 1);
insert into materia values(3, "8608","Introduccion a las Bases de Datos", 1);
insert into materia values(4, "8623","Ingenieria de Software 3", 1);
UNLOCK TABLES;


LOCK TABLES `edificio` WRITE;
insert into edificio values(1, "Jose Hernandez");
insert into edificio values(2, "Scalabrini Ortiz");
insert into edificio values(3, "Leopoldo Marechal");
UNLOCK TABLES;


LOCK TABLES `aula` WRITE;
insert into aula values(1, 11, 1);
insert into aula values(2, 9, 1);
insert into aula values(3, 1, 2);
insert into aula values(4, 6, 3);
UNLOCK TABLES;


LOCK TABLES `laboratorio` WRITE;
insert into laboratorio values(80, 100, 1);
insert into laboratorio values(90, 95, 2);
UNLOCK TABLES;


LOCK TABLES `tradicional` WRITE;
insert into tradicional values(70, "tiza", false, 3);
insert into tradicional values(50, "tiza", false, 4);
UNLOCK TABLES;


-- NOTA PEDIDO CURSADA
LOCK TABLES `nota_pedido` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) VALUES (1, 90, 'Aula con proyector', true, 'M', 1, 1, false);
UNLOCK TABLES;
-- PROFESORES DE LA NOTA PEDIDO
LOCK TABLES `nota_pedido_profesores` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (1, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (1, 2);
UNLOCK TABLES;
-- NOTA PEDIDO DEL TIPO CURSO
LOCK TABLES `curso` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso` (`comision`, `id`) values ('8616', 1);
UNLOCK TABLES;
-- FECHAS PARA EL CURSO
LOCK TABLES `fecha` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) VALUES (1, '2022/8/10');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (2, '2022/8/24');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (3, '2022/9/7');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (4, '2022/9/21');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (5, '2022/10/5');
UNLOCK TABLES;
-- CURSO_FECHAS
LOCK TABLES `curso_fechas` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (1, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (1, 2);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (1, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (1, 4);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (1, 5);
UNLOCK TABLES;


-- NOTA PEDIDO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) VALUES (2, 85, 'Aula para final escrito', true, 'T', 2, 2, false);
-- PROFESORES DE LA NOTA PEDIDO
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (2, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (2, 4);
-- NOTA PEDIDO DEL TIPO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`final` (`fecha`, `mesa`, `id`) values ('2022/10/15', '90', 2);


-- NOTA PEDIDO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) VALUES (3, 50, 'Final pocos alumnos', true, 'M', 3, 3, false);
-- PROFESORES DE LA NOTA PEDIDO
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (3, 5);
-- NOTA PEDIDO DEL TIPO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`final` (`fecha`, `mesa`, `id`) values ('2022/9/12', '99', 3);


-- NOTA PEDIDO CURSADA -- 
LOCK TABLES `nota_pedido` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) VALUES (4, 65, 'Aula tradicional', true, 'T', 4, 4, false);
UNLOCK TABLES;
-- PROFESORES DE LA NOTA PEDIDO
LOCK TABLES `nota_pedido_profesores` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (4, 6);
UNLOCK TABLES;
-- NOTA PEDIDO DEL TIPO CURSO
LOCK TABLES `curso` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso` (`comision`, `id`) values ('8623', 4);
UNLOCK TABLES;
-- FECHAS PARA EL CURSO
LOCK TABLES `fecha` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) VALUES (6, '2022/8/12');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (7, '2022/8/19');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (8, '2022/8/26');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (9, '2022/9/2');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (10, '2022/9/9');
UNLOCK TABLES;
-- CURSO_FECHAS
LOCK TABLES `curso_fechas` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (4, 6);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (4, 7);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (4, 8);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (4, 9);
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso_fechas` (`curso_id`, `fechas_id`) VALUES (4, 10);
UNLOCK TABLES;