<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="view.*"
    import = "java.util.*"	
    import ="controller.*"
    
    %>

	<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Sun Apr 23 2017 07:20:16 GMT+0000 (UTC)  -->
<html data-wf-page="58fc37d167a8320d4f298aed" data-wf-site="58fc160f3df4dd7655b11a5a">
<head>
  <meta charset="utf-8">
  <title>Visita - TNG24</title>
  <meta content="CrearPresupuesto" property="og:title">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
   
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
  <link href="assets/css/normalize.css" rel="stylesheet" type="text/css">
  <link href="assets/css/webflow.css" rel="stylesheet" type="text/css">
  <link href="assets/css/tng24.webflow.css" rel="stylesheet" type="text/css">
  <script src="assets/js/modernizr.js" type="text/javascript"></script>

  <link rel="stylesheet" href="assets/css/jquery-ui.css" />
</head>
<style>
    #mdialTamanio{
      width: 100% !important;
    }
  </style>
<body onload="setPage()" >


   	
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
             
                <a class="navbar-brand">TNG24</a> 
               
            </div>
            </nav>
            </div>
 
 
 
 
 
 
 
 

            
  <div class="nuevopresupuesto seccionhojaderuta">
    <div class="rowhojaderuta w-row">
      <div class="w-col w-col-6 w-col-small-6 w-col-tiny-6">
        <h4 id="tituloPantalla">Visita Numero:</h4>
      </div>
      <div class="w-clearfix w-col w-col-6 w-col-small-6 w-col-tiny-6">
      
      </div>
    </div>
  </div>
  
 
        <div class="rowdatoscliente w-row">
      
           <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="motivo">Motivo:</label>
          </div>
          <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
          
          
            <input value="" class="fieldnombre w-input" data-name="motivo" id="motivo" maxlength="256" name="Cliente"  type="text">
          </div>
 
         
         <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
                                             <label>Cliente:</label>
                                            <div class="form-group input-group">
                                            <input  id="cliente" name="cliente" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                                <button id="btnBuscarCLiente" class="btn btn-default" type="button" onclick="setModal('clientes')" data-toggle="modal"   data-target="#buscadorID"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                              
                                        </div>
                           
                                       </div>
										
         <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
                                             <label>Domicilio:</label>
                                            <div class="form-group input-group">
                                            <input  id="domicilio" name="domicilio" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                                 <button id="btnBuscarDomicilio" class="btn btn-default" type="button" onclick="setModal('domicilio')" data-toggle="modal"   data-target="#buscadorID"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>
                                         </div>
        <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
                                             <label>Tecnico:</label>
                                            <div class="form-group input-group">
                                            <input  id="tecnico" name="tecnico" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                                <button id="btnBuscarTecnico" class="btn btn-default" type="button" onclick="setModal('tecnico')" data-toggle="modal"   data-target="#buscadorID"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>  
                                         </div> 
                                         
          <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">                                
         <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="fecInicio">Fecha de Inicio:</label>
          </div>
          <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
          
          
            <input value="" class="fieldnombre w-input" data-name="fecInicio" id="fecInicio" maxlength="256" name="fecInicio"  type="text">
          </div> 
          
                   <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="horaInicio">Hora de Inicio:</label>
          </div>
          <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
          
          
            <input value="" class="fieldnombre w-input" data-name="horaInicio" id="horaInicio" maxlength="256" name="horaInicio"  type="text">
          </div>     
          
                   <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="horaFin">Hora de Fin:</label>
          </div>
          <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
          
          
            <input value="" class="fieldnombre w-input" data-name="horaFin" id="horaFin" maxlength="256" name="horaFin"  type="text">
          </div>  
          </div>
          
            <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
                                             <label>Factura:</label>
                                            <div class="form-group input-group">
                                            <input  id="factura" name="factura" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                                <button id="btnBuscarFactura" class="btn btn-default" type="button" onclick="setModal('factura')" ><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>
                           
                                       </div>                                  
                                        
                                        
   <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
                                             <label>Presupuesto:</label>
                                            <div class="form-group input-group">
                                            <input  id="presupuesto" name="presupuesto" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                               <button id="btnBuscarPresupuesto" class="btn btn-default" type="button" onclick="setModal('presupuesto')" data-toggle="modal"   data-target="#buscadorID"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>
                           
                                       </div>                                       
                                        
             
        <!--  INICIO DEL MODAL -->
         <div name="modales">
           <div class="modal fade" id="buscadorID" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"   >
                                <div class="modal-dialog" id="mdialTamanio">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 id="VistaClientesTitulo" class="modal-title" id="myModalLabel">Buscar:</h4>
                                        </div>
                                        <div class="modal-body">
                                        
							<div class="panel-body" id="tCliente"  style="display: block">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="tablaCliente">
                                    <thead>
                                        <tr>
                                            <th>ID:</th>
                                            <th>Apellido y Nombre</th>
                                            <th>Tipo Documento</th>
                                            <th>Documento</th>
											<th>Telefono</th>
                                            <th>Mail</th>
											<th>Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									
									
                                       	<%
                                       	CtrlEnte sysCli = CtrlEnte.getInstance();
                                       	
                                       	ArrayList<ViewCliente> lista = sysCli.listarClientes(null, null, null);
                                       if(lista!=null){
                                       	for(ViewCliente vc: lista){
                                       		out.println(vc.vistaTabla());
                                          				}
                                       	}
                                                 		 %>  
										
                                    </tbody>
                                </table>
                            </div>			
                        </div>
                        <div class="panel-body" id="tdom"  style="display: block">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="tablaDomicilio">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Provincia</th>
                                            <th>Ciudad</th>
                                            <th>Codigo Postal</th>
                                            <th>Calle</th>
                                            <th>Numero</th>
                                            <th>Piso</th>
                                            <th>Dpto</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
									<%
                                       CtrlDomicilio sysDom = CtrlDomicilio.getInstance();
                                       for(ViewDomicilio v: sysDom.listarDomicilios()){
                                       		out.println(v.vistaTabla());
                                          				}
                                                 		 %>                                    
                                    
                                    
                                     
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-body" id="tPresupuesto"  style="display: block">
                        		 <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="tablaPresupuesto">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Fecha Emsion</th>
                                            <th>Descripcion</th>
                                            <th>Apelido y Nombre</th>
                                            <th>Documento</th>
											<th>Tecnico</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									
									
                                       	<%
                                       	CtrlAgenda sysAgenda = CtrlAgenda.getInstance();
                                      
                                       	for(ViewPresupuesto vp: sysAgenda.listarPresupuestos(null, null, null, null)){
                                       		out.println(vp.vistaTabla());
                                          				}
                                       	
                                                 		 %>  
										
                                    </tbody>
                                </table>
                            </div>
                             </div>
                             
                             <div class="panel-body" id="tTecnico"  style="display: block">
                        		 <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="tablaTecnico">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Apelido y Nombre</th>
                                            <th>Documento</th>
											
                                        </tr>
                                    </thead>
                                    <tbody>
									
									
                                       	<%
                                       	CtrlEnte sysEmp = CtrlEnte.getInstance();
                                       	
                                       
                                       	for(ViewEmpleado vc: sysEmp.listaTecnicos()){
                                       		out.println(vc.vistaTabla());
                                          				
                                       	}
                                                 		 %>  
										
                                    </tbody>
                                </table>
                            </div>
                             </div>
										
										
                                        
                                       </div> 
                                    </div>
                                </div>
                            </div>
							</div>
							<!--  FIN DEL MODAL -->



        
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>--> 
  <script src="assets/js/webflow.js" type="text/javascript"></script>

 <script src="assets/js/jquery-1.10.2.js"></script>
 <script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/jquery.ui.datepicker-es.js"></script>
    <script>
$(function () {
$.datepicker.setDefaults($.datepicker.regional["es"]);
$("#fecInicio").datepicker({
firstDay: 1
});
});
</script>        
<!-- INICIA INSERT LOGICA MODAL -->

 <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      
    <!-- DATA TABLE SCRIPTS     -->

   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>

$(document).ready(function () {$('#tablaCliente').dataTable();});			
$(document).ready(function () {$('#tablaDomicilio').dataTable();});	
$(document).ready(function () {$('#tablaPresupuesto').dataTable();});
$(document).ready(function () {$('#tablaTecnico').dataTable();});
	</script>



<!-- FIN INSERT LOGICA MODAL -->
<script type="text/javascript">
$(document).on("click", "tr.bodyTableCliente" , function(){
	
		var celda = $(this).children("#id").text();
		cliente.value =celda;
		$('#buscadorID').modal('toggle');
	
}
);

$(document).on("click", "tr.bodyTableDom" , function(){
	
	var celda = $(this).children("#id").text();
	domicilio.value =celda;
	$('#buscadorID').modal('toggle');

}
);
$(document).on("click", "tr.bodyTableTecnico" , function(){
	
	var celda = $(this).children("#id").text();
	tecnico.value =celda;
	$('#buscadorID').modal('toggle');

}
);

$(document).on("click", "tr.bodytablaPresupuesto" , function(){
	
	var celda = $(this).children("#id").text();
	presupuesto.value =celda;
	$('#buscadorID').modal('toggle');

}
);
	
	</script>


<script>


function setModal(opc) {
	
	
	if(opc=="clientes"){
		document.getElementById("tCliente").setAttribute("style","display: block");
		document.getElementById("tdom").setAttribute("style","display: none");
		document.getElementById("tPresupuesto").setAttribute("style","display: none");
		document.getElementById("tTecnico").setAttribute("style","display: none");
	}
	
	if(opc=="domicilio"){
		document.getElementById("tCliente").setAttribute("style","display: none");
		document.getElementById("tdom").setAttribute("style","display: block");
		document.getElementById("tPresupuesto").setAttribute("style","display: none");
		document.getElementById("tTecnico").setAttribute("style","display: none");
	}
	if(opc=="tecnico"){
		document.getElementById("tCliente").setAttribute("style","display: none");
		document.getElementById("tdom").setAttribute("style","display: none");
		document.getElementById("tPresupuesto").setAttribute("style","display: none");
		document.getElementById("tTecnico").setAttribute("style","display: block");
	}
	if(opc=="presupuesto"){
		document.getElementById("tCliente").setAttribute("style","display: none");
		document.getElementById("tdom").setAttribute("style","display: none");
		document.getElementById("tPresupuesto").setAttribute("style","display: block");
		document.getElementById("tTecnico").setAttribute("style","display: none");
	}
	
}


    

</script>




</body>
</html>