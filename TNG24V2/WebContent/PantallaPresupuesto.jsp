<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   

    %>
<%@ page 
	import = "controller.CtrlEnte" 
	import = "controller.CtrlDomicilio" 
	import = "controller.CtrlAgenda" 
	import ="view.*"	
	import = "java.util.*"
		%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TNG24</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
   
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link rel="stylesheet" href="assets/css/jquery-ui.css" />
   


</head>
 <style>
    #mdialTamanio{
      width: 80% !important;
    }
  </style>
<body id="body" >

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">TNG24</a> 
            </div>
   <div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
  <a href="assets/manuales/manual.pdf" target="_blank" class="btn btn-info square-btn-adjust pull-left" style="margin-right:3px;">?</a>
 	<form action="LoginServlet" method="POST">
 		<input type="hidden" value="logout" name="logout"> 
 	<button type="submit" class="btn btn-danger square-btn-adjust">Salir</button>
 	</form> 
	 	</div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
			
                        <a class="active-menu"  href="PantallaPresupuesto.jsp"><i class="fa fa-edit fa-3x"></i>Presupuestos</a>
                    </li>	
                  <li  >
                        <a   href="PantallaCliente.jsp"><i class="fa fa-user  fa-3x"></i> Clientes</a>
                    </li>	
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Presupuestos</h2>   
                     	 
                        
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
				<button class="btn btn-danger btn-lg" data-toggle="modal" onClick="setModalBuscador()" data-target="#buscadorPresupuesto">
                            Buscar Presupuestos
                            </button> 
                        
                            
               
			<hr />				
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
                                       	ArrayList<ViewPresupuesto> lista = (ArrayList<ViewPresupuesto>) session.getAttribute("listaPresupuestos");
                                       if(lista!=null){
                                       	for(ViewPresupuesto vp: lista){
                                       		out.println(vp.vistaTabla());
                                          				}
                                       	}
                                                 		 %>  
										
                                    </tbody>
                                </table>
                            </div>					
                              
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
        
        
        <!--Modales en este div se aljan los modales necesarios para el funcionamiento de esta pantalla  en este -->
        <div name="modales">
           			
				<div class="modal fade" id="buscadorPresupuesto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabelB">Buscar</h4>
                                        </div>
                                        <div class="modal-body">
                                           <form form="role" id="fbuscarPresupuestos" method="POST" action="PresupuestosSERVLET">	
										   <div class="form-group">
                                        
                                            <label>Presupuesto Numero:</label>
                                            <input id="bNroPresupuesto" name="bNroPresupuesto" class="form-control" />
                                            </div>
                                         <div class="form-group">
                                            <label>Fecha Emision:</label>
											<input type="text" id="datepicker" name="fechaEmision"  class="form-control"  />	
                                            </div>
                                             
											 <div class="form-group">
                                            <label>Apellido:</label>
                                            <input id="bApellido" name="bApellido" class="form-control" />
                                            </div>
											<div class="form-group">
                                            <label>Nombre:</label>
                                            <input id="bNombre" name="bNombre" class="form-control" />
                                            </div>
                                             <div class="form-group">
                                            <label>Documento:</label>
                                            <input id="bDocumento" name="bDocumento" class="form-control" />
                                            </div>
										   
										   
											<input  type="hidden" id="buscar" name="buscar"/>
                                            <button type="button" class="btn btn-danger" onClick="buscarPresupuesto()">Buscar</button>
											</form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                  
                            
                        

        
        <div type="hidden" >
        <form form="role" id="fmostrarPresupuesto" method="POST" action="PresupuestoDetalleSERVLET">
        <input  type="hidden" id="mostrarPresupuesto" name="mostrarPresupuesto"/>
        <input  type="hidden" id="idm" name="idm"/>
        
        </form>
        </div>

        
        </div>
        
     
        
        
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
  
      <script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/jquery.ui.datepicker-es.js"></script>
    <script>
$(function () {
$.datepicker.setDefaults($.datepicker.regional["es"]);
$("#datepicker").datepicker({
firstDay: 1
});
});
</script>

      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    
    <!-- DATA TABLE SCRIPTS     -->

   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>

	$(document).ready(function () {$('#tablaPresupuesto').dataTable();});
	

		
	$(document).on("click", "tr.bodytablaPresupuesto" , function(){
		
		var celda = $(this).children("#id").text();
		document.getElementById("mostrarPresupuesto").value="mostrarPresupuesto";
		alert(document.getElementById("mostrarPresupuesto").value);
		idm.value=celda;
		fmostrarPresupuesto.submit();
		
	});

	
	
	
		</script>
   
   <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   <script type="text/javascript">
	
	  function setModalBuscador(){
  
			document.getElementById("bNroPresupuesto").value="";
			document.getElementById("bFechaEmision").value="";
			document.getElementById("bApellido").value="";
			document.getElementById("bNombre").value="";
			document.getElementById("bDocumento").value="";
			document.getElementById("bFechaEmision").disabled = true;
	 
  
   }
  
	
	 
	  function buscarPresupuesto(){
		   
		   document.getElementById("buscar").value="buscarPresupuestos";

		   
		   document.getElementById("fbuscarPresupuestos").submit();
		   
		   
	   }
	 
   
   </script> 
   
</body>
</html>