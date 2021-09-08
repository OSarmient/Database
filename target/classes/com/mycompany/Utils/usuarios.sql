create table usuarios(
    correo_electronico varchar(56) not null primary key,
    nombres varchar(56) not null,
    apellidos varchar(56) not null,
    edad int not null,
    contraseña varchar(56) not null,
    id_rol int,
    foreign key (id_rol) references roles (id_rol)
);
