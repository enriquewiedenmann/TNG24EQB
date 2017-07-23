alter table ct_presupuesto
add motivo nvarchar(200)


update ct_presupuesto
set motivo = concat('motivo presupueto ',IDPRESUPUESTO)


