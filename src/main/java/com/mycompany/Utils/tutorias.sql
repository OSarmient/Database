create table tutorias(
    id_tutoria int not null primary key,
    titulo varchar(512) not null,
    descripcion varchar(1024) not null,
    año int not null,
    id_docente_encargado varchar(56) not null,
    foreign key (id_docente_encargado) references usuarios(correo_electronico)
);
