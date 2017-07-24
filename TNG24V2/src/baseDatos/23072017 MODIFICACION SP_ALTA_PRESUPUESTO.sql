GO
/****** Object:  StoredProcedure [dbo].[SP_ALTA_PRESUPEUSTO]    Script Date: 23/07/2017 23:05:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[SP_ALTA_PRESUPEUSTO]
@IDPRESUPUESTO  INT OUTPUT,
@FECHAEMISIONPRESUPUESTO DATE,
@IDCLIENTE   INT,
@IDTECNICO  INT,
@TIEMPOMANOOBRA INT ,
@MONTOMANOOBRA INT,
@MOTIVO NVARCHAR(100)
AS
insert into ct_presupuesto(FECHAEMISIONPRESUPUESTO,IDCLIENTE,IDTECNICO,TIEMPOMANOOBRA,MONTOMANOOBRA,MOTIVO) 
values(@FECHAEMISIONPRESUPUESTO,@IDCLIENTE,@IDTECNICO,@TIEMPOMANOOBRA,@MONTOMANOOBRA,@MOTIVO);

SELECT @IDPRESUPUESTO=MAX(IDPRESUPUESTO) FROM CT_PRESUPUESTO