CREATE DATABASE tp2ahorcado;

USE tp2ahorcado;

CREATE TABLE palabras (
	id_Palabra int auto_increment,
	palabra varchar (20),
    primary key (id_Palabra)
);

CREATE TABLE ganadores (
	id_Ganador int not null auto_increment,
	nombre_Ganador varchar (50),
    apellido_Ganador varchar (50),
    fecha Date not null,
    palabraGanadora varchar(20),
    primary key (id_Ganador) 
);

INSERT INTO palabras (palabra)
VALUES ('Pelota'),('Doctorado'),('Marmota'),('Coloquio'),('Ventana'),('Caramelo'),('Encestar'),('Fernet'),('Independencia'),('Remoto');

select * from ganadores;

drop table ganadores;

select palabra from palabras where id_Palabra = 4;