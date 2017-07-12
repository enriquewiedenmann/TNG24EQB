

INSERT INTO TG_TIPODOCUMENTO VALUES('DN','DNI','A'),
('DT','CUIT','A'),
('CL','CUIL','A')

/*
INSERT INTO TG_ENTE VALUES('ENRIQUE','WIEDENMANN','DN','33914084','A'),
('ALEJANDRO','LOUBES','DN','1111111','A'),
('PABLO','FILONZI','DN','2222222','A'),
('GONZALO','PAEZ','DN','333333','A')
*/

INSERT INTO TG_ROLLEMPPLEADO VALUES('TEC','TECNICO','A'),
('ADT','ADMINISTRADOR TECNICOS','A'),
('GER','GERENCIA','A'),
('ECS','ENCARGADO DE STOCK','A')

go

SELECT 
TB.name AS ENTIDAD,
COL.name AS ATRIBUTO

FROM SYS.tables TB join sys.columns col  on col.object_id = tb.object_id


CREATE TABLE ACC(
pre VARCHAR(255),
pos VARCHAR(255)
)

INSERT INTO ACC values('El sistema debe permitir dar de alta ',''),
('El sistema debe permitir dar de baja ',''),
INSERT INTO ACC values('El sistema debe permitir dar rehabilitar ',''),
('El sistema debe permitir modificar ',''),
('El sistema debe permitir mostrar ',''),
('El sistema debe permitir listar ',''),
('El sistemadebe permitir buscar ',' por ')


select 
a.pre,
concat(substring((lower(t.name)),4,20),'s'),
a.pos

from
acc a,
sys.tables t
