create table matriculas(
    id_matriculas int primary key,
    id_estudiante varchar(56),
    id_tutoria int,
    foreign key (id_estudiante) references usuarios(correo_electronico),
    foreign key (id_tutoria) references tutorias(id_tutoria)
);
