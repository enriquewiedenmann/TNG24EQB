CREATE VIEW V_VISITA(
IDVISITA,    
IDAGENDA,    
IDFACTURA,   
IDPRESUPPUESTO, 
IDCLIENTE,   
IDDOMICILIO, 
INICIOPROGRAMADO,        
FINPROGRAMADO,           
INICIOREAL,              
FINREAL,                 
ESTADO, 
MOTIVO,                                                                                                                                                                                                                                                           
IDTECNICO)
AS
select 
vi.IDVISITA,
vi.IDAGENDA,
vi.IDFACTURA,
vi.IDPRESUPPUESTO ,
vi.IDCLIENTE   ,
vi.IDDOMICILIO ,
vi.INICIOPROGRAMADO  ,      
vi.FINPROGRAMADO   ,        
vi.INICIOREAL    ,          
vi.FINREAL      ,           
vi.ESTADO ,
vi.MOTIVO,
ag.IDTECNICO
 from TNG24V1.dbo.CT_VISITA vi join TNG24V1.dbo.CT_AGENDA ag on ag.IDAGENDA = vi.IDAGENDA 
