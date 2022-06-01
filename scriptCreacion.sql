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
VALUES(1, "Administrador", "Administrador", 0, "admin@gmail.com", "admin", "$2a$10$glvtPMbUNyNMoaa6SF9hWOYwPt.hDt.cHs/bJagJ9Kaf3Shpt2co6", true, now(), now(), 1);
INSERT INTO usuario (id_usuario, nombre, apellido, dni, email, nombre_usuario, clave, activo, createdat, updatedat, id_perfil) 
VALUES(2, "Auditoria", "Auditoria", 1, "Auditoria@gmail.com", "auditor", "$2a$10$t6McDb.aIokbKk6RkdCe2eiHn0xCpbi8w01bYlyQ3VGjIXzfdC7Ru", true, now(), now(), 2);
UNLOCK TABLES;


LOCK TABLES `departamento` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`departamento` (`id`, `departamento`) VALUES (1, "Departamento de Desarrollo Productivo y Tecnologico");
UNLOCK TABLES;


LOCK TABLES `carrera` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`carrera` (`id`, `carrera`,  `id_departamento`) VALUES (1, "Licenciatura en Sistemas", 1);
UNLOCK TABLES;


LOCK TABLES `profesor` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (1, "Vranic", "Alejandra");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (2, "Siciliano", "Gustavo");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (3, "Mansilla", "Romina");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (4, "Golfieri", "Jorge");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (5, "Perez", "Nicolas");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (6, "Garcia", "Roberto");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (7, "Bianco", "Santiago");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (8, "Plaul", "Vanesa");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (9, "Loidi", "Laura");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (10, "Di Dio", "Edgardo");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (11, "Millan", "Luis");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (12, "Charczuk", "Norberto");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (13, "Manuel Defelippe", "Joan");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (14, "Scordamaglia", "Ezequiel ");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (15, "Diez", "Eduardo");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (16, "Sasin", "Alejandro");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (17, "Pytel", "Pablo");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (18, "Ribeiro", "Federico");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (19, "Rios", "Leandro");
INSERT INTO `grupo-10-bdd-oo2-2022`.`profesor` (`id`, `apellido`, `nombre`) VALUES (20, "Amatriain", "Hernan");
UNLOCK TABLES;


LOCK TABLES `materia` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (1, "8600", "Programación de Computadoras", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (2, "8601", "Organización de Computadoras", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (3, "8602", "Arquitectura de Computadoras", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (4, "8603", "Matemática 1", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (5, "8604", "Matemática 2", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (6, "8605", "Expresión de Problemas y Algoritmos", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (7, "8606", "Introducción al Pensamiento Científico", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (8, "8607", "Ingeniería de Software 1", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (9, "8608", "Introducción a las Bases de Datos", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (10, "8609", "Algoritmos y Estructuras de Datos", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (11, "8610", "Orientación a Objetos 1", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (12, "8612", "Introducción a los Sistemas Operativos", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (13, "8613", "Matemática 3", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (14, "8640", "Probabilidad y Estadística", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (15, "8615", "Ingeniería de Software 2", 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`materia` (`id`, `codigo`, `materia`, `id_carrera`) VALUES (16, "8616", "Orientación a Objetos 2", 1);
UNLOCK TABLES;


LOCK TABLES `edificio` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (1, "Jose Hernandez");
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (2, "Scalabrini Ortiz");
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (3, "Leopoldo Marechal");
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (4, "Arturo Jauretche");
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (5, "Juana Manso");
INSERT INTO `grupo-10-bdd-oo2-2022`.`edificio` (`id`, `edificio`) VALUES (6, "Homero Manzi");
UNLOCK TABLES;


LOCK TABLES `aula` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (1, 9, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (2, 10, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (3, 11, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (4, 6, 2);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (5, 7, 2);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (6, 8, 2);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (7, 1, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (8, 2, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (9, 3, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (10, 5, 4);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (11, 4, 4);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (12, 3, 4);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (13, 12, 5);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (14, 5, 5);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (15, 2, 5);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (16, 1, 6);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (17, 2, 6);
INSERT INTO `grupo-10-bdd-oo2-2022`.`aula` (`id`, `numero`, `id_edificio`) VALUES (18, 4, 6);
UNLOCK TABLES;


LOCK TABLES `laboratorio` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (1, 90, 95);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (2, 80, 80);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (3, 85, 85);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (4, 75, 80);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (5, 70, 80);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (6, 65, 70);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (7, 60, 70);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (8, 55, 60);
INSERT INTO `grupo-10-bdd-oo2-2022`.`laboratorio` (`id`, `cantpc`, `cant_sillas`) VALUES (9, 50, 65);
UNLOCK TABLES;


LOCK TABLES `tradicional` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (10, true, "Tiza", 80);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (11, false, "Fibron", 65);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (12, false, "Tiza", 70);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (13, false, "Fibron", 55);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (14, true, "Tiza", 75);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (15, false, "Fibron", 50);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (16, true, "Tiza", 65);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (17, false, "Fibron", 60);
INSERT INTO `grupo-10-bdd-oo2-2022`.`tradicional` (`id`, `tiene_proyector`, `pizarron`, `cant_bancos`) VALUES (18, true, "Tiza", 80);
UNLOCK TABLES;


-- NOTA PEDIDO CURSADA
LOCK TABLES `nota_pedido` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`)
 VALUES (1, 90, 'Aula con proyector', true, 'M', 1, 1, true);
UNLOCK TABLES;
-- PROFESORES DE LA NOTA PEDIDO
LOCK TABLES `nota_pedido_profesores` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (1, 1);
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (1, 2);
UNLOCK TABLES;
-- NOTA PEDIDO DEL TIPO CURSO
LOCK TABLES `curso` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso` (`comision`, `id`) values ('8600', 1);
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

-- FECHAS PARA FINALES
LOCK TABLES `fecha` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (11, '2022/9/12');
INSERT INTO `grupo-10-bdd-oo2-2022`.`fecha` (`id`, `fecha`) values (12, '2022/10/15');
UNLOCK TABLES;

-- NOTA PEDIDO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) 
VALUES (2, 85, 'Aula para final escrito', true, 'T', 2, 2, true);
-- PROFESORES DE LA NOTA PEDIDO
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (2, 3);
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (2, 4);
-- NOTA PEDIDO DEL TIPO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`final` (`id_fecha`, `mesa`, `id`) values (12, '90', 2);


-- NOTA PEDIDO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) 
VALUES (3, 50, 'Final pocos alumnos', true, 'M', 3, 3, true);
-- PROFESORES DE LA NOTA PEDIDO
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (3, 5);
-- NOTA PEDIDO DEL TIPO FINAL
INSERT INTO `grupo-10-bdd-oo2-2022`.`final` (`id_fecha`, `mesa`, `id`) values (11, '99', 3);


-- NOTA PEDIDO CURSADA -- 
LOCK TABLES `nota_pedido` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido` (`id`, `cant_estudiantes`, `observaciones`, `pendiente`, `turno`, `id_aula`, `id_materia`, `activo`) 
VALUES (4, 65, 'Aula tradicional', false, 'T', 4, 4, true);
UNLOCK TABLES;
-- PROFESORES DE LA NOTA PEDIDO
LOCK TABLES `nota_pedido_profesores` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`nota_pedido_profesores` (`nota_pedido_id`, `profesores_id`) values (4, 6);
UNLOCK TABLES;
-- NOTA PEDIDO DEL TIPO CURSO
LOCK TABLES `curso` WRITE;
INSERT INTO `grupo-10-bdd-oo2-2022`.`curso` (`comision`, `id`) values ('8603', 4);
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