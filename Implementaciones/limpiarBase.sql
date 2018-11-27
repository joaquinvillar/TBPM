
truncate table public.estudiante_expediente;
truncate table public.docente_expediente;
delete from public.expediente;
delete from public.movilidad;
delete from public.estudiante;
-- inserto los estudiantes nuevamente, los iniciales
INSERT into estudiante values('48635700','estudiante 1','Ingenieria en Computacion',190,'rutaCV1');
INSERT into estudiante values('12345678','estudiante 2','Ingenieria en Computacion',300,'rutaCV2');
INSERT into estudiante values('48765432','estudiante 3','Ingenieria en Computacion',100,'rutaCV3');
INSERT into estudiante values('34567890','estudiante 4','Ingenieria en Computacion',150,'rutaCV4');
INSERT into estudiante values('21346578','estudiante 5','Ingenieria en Computacion',80,'rutaCV5');
