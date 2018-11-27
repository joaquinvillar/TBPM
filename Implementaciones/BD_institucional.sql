CREATE TABLE public.Docente
(
  docenteId text NOT NULL,--cedula de identidad
  nombre text,
  departamento text,
  CONSTRAINT "PK_docente" PRIMARY KEY (docenteId)
);

CREATE TABLE public.Estudiante
(
	estudianteId text not null,--cedula de identidad
	nombre text not null,-- nombre y apellido
	carrera text not null,
	creditosAprob integer not null,
	CV text not null, -- corresponde a la ubicacion del archivo
	CONSTRAINT "PK_estudiante" PRIMARY KEY (estudianteId)

);

CREATE TABLE public.Movilidad
(
	
	movilidadNombre text NOT NULL,
	convocatoriaId text NOT NULL,
	movilidadNumero serial,
	fechaInicio date,
	fechaFin date,
	descripcion text,
	duracion numeric, -- en meses
	bases text,
	computacion boolean,
	produccion boolean,
	civil boolean,
	electrica boolean,
	nombreContacto text,
	emailContacto text,
	universidadId integer,


	CONSTRAINT "PK_Movilidad" PRIMARY KEY (movilidadNombre,convocatoriaId)
);

CREATE TABLE public.Expediente
(
  expedienteId text NOT NULL,
  fechaInicioPostulacion date,
  fechaFinPostulacion date,
  docenteRefId text,
  movilidadNombre text,
  convocatoriaId text,
  razon text,
  estado integer,
  tieneInforme boolean,
  informerechazado boolean,
  CONSTRAINT "PK_Expediente" PRIMARY KEY (expedienteId)
);


CREATE TABLE public.Universidad
(
	universidadId integer NOT NULL,
	universidadNombre text,
	paisId integer,
	CONSTRAINT "PK_Universidad" PRIMARY KEY (universidadId)
);


CREATE TABLE public.Pais
(
	paisId integer NOT NULL,
	paisNombre text NULL,
	CONSTRAINT "PK_Pais" PRIMARY KEY (paisId)
);

CREATE TABLE public.docente_expediente
(
	docenteId text not null,
	expedienteId text not null,
	CONSTRAINT "PK_doc_exp" PRIMARY KEY (docenteId,expedienteId)

);

CREATE TABLE public.estudiante_expediente
(
	estudianteId text not null,
	expedienteId text not null,
	universidadId integer,
	estado integer,
	prioridad integer,

	CONSTRAINT "PK_est_exp" PRIMARY KEY (estudianteId,expedienteId)
);

CREATE TABLE public.usuario
(
	usuario text not null,
	password text,
	rol text,
	CONSTRAINT "PK_usuario" PRIMARY KEY (usuario)
);



-- FK de la tabla movilidad


ALTER TABLE public.Movilidad ADD CONSTRAINT FK_Universidad_Movilidad FOREIGN KEY(UniversidadId)
REFERENCES Universidad (UniversidadId);



-- FK expediente
ALTER TABLE public.Expediente ADD CONSTRAINT FK_Expediente_Movilidad FOREIGN KEY(movilidadNombre,convocatoriaId)
REFERENCES Movilidad (movilidadNombre,convocatoriaId);

ALTER TABLE public.Expediente ADD CONSTRAINT FK_Expediente_DocenteRef FOREIGN KEY(docenteRefId)
REFERENCES Docente (docenteId);
-- FK universidad
ALTER TABLE public.Universidad ADD CONSTRAINT FK_Pais_Universidad FOREIGN KEY(paisId)
REFERENCES Pais (paisId);


-- FK de la tabla estudiante


-- FK de la tabla estudiante_expediente
ALTER TABLE public.estudiante_expediente ADD CONSTRAINT FK_estudiante_expediente FOREIGN KEY(estudianteId)
REFERENCES Estudiante (estudianteId);

ALTER TABLE public.estudiante_expediente ADD CONSTRAINT FK_estudiante_expediente2 FOREIGN KEY(expedienteId)
REFERENCES expediente (expedienteId);

-- FK de la tabla docente_expediente
ALTER TABLE public.docente_expediente ADD CONSTRAINT FK_docente_expediente FOREIGN KEY(docenteId)
REFERENCES Docente (docenteId);

ALTER TABLE public.docente_expediente ADD CONSTRAINT FK_docente_expediente2 FOREIGN KEY(expedienteId)
REFERENCES expediente (expedienteId);

-- FK de universidad

--******************INGRESO DE JUEGO DE DATOS**************************

-- docentes
INSERT into docente values('11111111','Docente 1','Computacion');
INSERT into docente values('22222222','Docente 2','Computacion');
INSERT into docente values('33333333','Docente 3','Arquitectura');
INSERT into docente values('44444444','Docente 4','Arquitectura');

-- paises
INSERT into pais values(1,'Uruguay');
INSERT into pais values(2,'Japon');
INSERT into pais values(3,'Estados Unidos');
INSERT into pais values(4,'Canada');
INSERT into pais values(5,'Portugal');
INSERT into pais values(6,'Brasil');

-- universidades

INSERT into universidad values(1,'Universidad de Stanford',3);
INSERT into universidad values(2,'Universidad de Toronto',4);
INSERT into universidad values(3,'Universidad de Harvard',3);
INSERT into universidad values(4,'Universidad de Tokio',2);
INSERT into universidad values(5,'Universidad de San Pablo',6);
INSERT into universidad values(6,'Universidad de Lisboa',5);
INSERT into universidad values(7,'Facultad de Ingenieria Uruguay',1);



-- estudiantes
INSERT into estudiante values('48635700','estudiante 1','Ingenieria en Computacion',190,'rutaCV1');
INSERT into estudiante values('12345678','estudiante 2','Ingenieria en Computacion',300,'rutaCV2');
INSERT into estudiante values('48765432','estudiante 3','Ingenieria en Computacion',100,'rutaCV3');
INSERT into estudiante values('34567890','estudiante 4','Ingenieria en Computacion',150,'rutaCV4');
INSERT into estudiante values('21346578','estudiante 5','Ingenieria en Computacion',80,'rutaCV5');


-- usuarios
INSERT into usuario values('usuario1','1234','DGRC');
INSERT into usuario values('usuario2','1234','DGRC');
INSERT into usuario values('usuario3','1234','decano');
INSERT into usuario values('usuario4','1234','decano');
