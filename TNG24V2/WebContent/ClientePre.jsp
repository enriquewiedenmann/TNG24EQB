<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   

    %>
<%@ page 
	import = "ctrl.CtrlEnte" 
	import = "ctrl.CtrlDomicilio" 
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
</head>
 <style>
    #mdialTamanio{
      width: 80% !important;
    }
  </style>s
<body id="body">

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
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;">  <a href="#" class="btn btn-danger square-btn-adjust">Salir</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
				
					
                    <li>
                        <a  href="index.html"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                      <li>
                        <a  href="ui.html"><i class="fa fa-desktop fa-3x"></i> UI Elements</a>
                    </li>
                    <li>
                        <a  href="tab-panel.html"><i class="fa fa-qrcode fa-3x"></i> Tabs & Panels</a>
                    </li>
						   <li  >
                        <a  href="chart.html"><i class="fa fa-bar-chart-o fa-3x"></i> Morris Charts</a>
                    </li>	
                      <li  >
                        <a  href="table.html"><i class="fa fa-table fa-3x"></i> Table Examples</a>
                    </li>
                    <li  >
                        <a  href="form.html"><i class="fa fa-edit fa-3x"></i> Forms </a>
                    </li>				
					
					                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-3x"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>
                               
                            </li>
                        </ul>
                      </li>  
                  <li  >
                        <a class="active-menu"  href="CLientePre.jsp"><i class="fa fa-user  fa-3x"></i> Clientes</a>
                    </li>	
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Clientes</h2>   
                        
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
				<button class="btn btn-danger btn-lg" data-toggle="modal" data-target="#buscadorCliente">
                            Buscar Clientes
                            </button> 
               <button class="btn btn-danger btn-lg" data-toggle="modal" onClick="setModalCliente('alta')" data-target="#VistaClientes">
                             Nuevo Cliente
                            </button>
			<hr />				
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
                                       	ArrayList<ViewCliente> lista = (ArrayList<ViewCliente>) request.getAttribute("listaCliente");
                                       if(lista!=null){
                                       	for(ViewCliente vc: lista){
                                       		out.println(vc.vistaTabla());
                                          				}
                                       	}
                                                 		 %>  
										<!--  <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
											<td class="center">X</td>
											<td class="center">X</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Trident</td>
                                            <td>Internet Explorer 5.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">5</td>
                                            <td class="center">C</td>
											<td class="center">X</td>
											<td class="center">X</td>
                                        </tr>
                                     -->
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
           <div class="modal fade" id="VistaClientes" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"   >
                                <div class="modal-dialog" id="mdialTamanio">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 id="VistaClientesTitulo" class="modal-title" id="myModalLabel">Modal title Here</h4>
                                        </div>
                                        <div class="modal-body">
                                        <form form="role" id="fCliente" style="display: block" method="POST" action="Cliente">
                                        <div class="form-group">
                                        
                                            <label>Id:</label>
                                            <input enable="false" id="idCliente"  name="idCliente" class="form-control" disabled/>
                                            </div>
                                        
                                        
                                        <div class="form-group">
                                        
                                            <label>Nombre:</label>
                                            <input id="nombreCliente" name="nombreCliente" class="form-control" />
                                            </div>
                                         <div class="form-group">
                                            <label>Apellido:</label>
                                            <input id="apellidoCliente" name="apellidoCliente" class="form-control" />
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="tipoDocumento">Tipo Docmento:</label>
                                                <select id="tipoDocumento" name="tipoDocumento"  class="form-control">
                                        			  <%
                                                 		CtrlEnte sys = CtrlEnte.getInstance();
                                          				for(ViewTipoDocumento v: sys.listarTipoDocs()){
                                          			
                                          			out.println(v.vistaOption());
                                          				}
                                                 		 %>
                                        	
                                                </select>
                                            </div>
                                             <div class="form-group">
                                            <label>Nro. Documento:</label>
                                            <input id="nroDocmento" name="nroDocmento" class="form-control" />
                                            </div>
                                            
                                            
                                              <div class="form-group">
                                            <label>Telefono: </label>
                                            <input id="telefono"  name="telefono" class="form-control" />
                                            </div>
                                            
                                             <div class="form-group">
                                            <label>Mail: </label>
                                            <input id="mail" name="mail" class="form-control" />
                                            </div>
                                             <label>Domicilio</label>
                                            <div class="form-group input-group">
                                            <input id="domicilio" name="domicilio" type="text" class="form-control">
                                            <span class="input-group-btn" onclick="verDomicilios()">
                                                <button class="btn btn-default" type="button" ><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                            
                                        </div>
										  <div class="form-group">
                                            <label>Estado: </label>
                                            <input id="estado"  name="estado" class="form-control" disabled/>
											
                                            </div>
											 <input type="hidden" id="accion" name="accion"/>  
										  <button type="button" class="btn btn-danger" id="btnAceptar" onClick="nuevoCliente()">Aceptar</button>
										   <button type="button" class="btn btn-danger" id="btnEditar" >Editar</button>
										    <button type="button" class="btn btn-danger" id="btnGuardar" onClick="editarCliente()">Guardar</button>
											 <button type="button" class="btn btn-danger" id="btnEstado" onClick="setEstadoCliente()">Baja</button>
											 
             			             </form>
                                        
							<div class="panel-body" id="tdom"  style="display: none">
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
										
										
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
							
							
							
							
				<div class="modal fade" id="buscadorCliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Buscar</h4>
                                        </div>
                                        <div class="modal-body">
                                           <form form="role" id="fbuscarCliente" method="POST" action="Cliente">	
										   <div class="form-group">
                                        
                                            <label>Nombre:</label>
                                            <input id="bnombreCliente" name="bnombreCliente" class="form-control" />
                                            </div>
                                         <div class="form-group">
                                            <label>Apellido:</label>
                                            <input id="bapellidoCliente" name="bapellidoCliente" class="form-control" />
                                            </div>
                                                                                     
                                             <div class="form-group">
                                            <label>Nro. Documento:</label>
                                            <input id="bnroDocmento" name="bnroDocmento" class="form-control" />
                                            </div>
										   
										   
											<input type="hidden" id="accion1" name="accion"/>  
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-danger" onClick="buscarCliente()">Buscar</button>
											</form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                  
                            
                        

        
        
        
        
        </div>
        
     
        
        
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      
    <!-- DATA TABLE SCRIPTS     -->

   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>

	$(document).ready(function () {$('#tablaCliente').dataTable();});
	$(document).ready(function () {$('#tablaDomicilio').dataTable();});			
	
	
	
	$(document).on("click", "tr.body" , function(){
		
		var celda = $(this).children("#id").text();
		
		domicilio.value =celda;
		
		document.getElementById("fCliente").setAttribute("style","display: block");
		document.getElementById("tdom").setAttribute("style","display: none");
		
	});
	
	
		</script>
   
   <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   <script type="text/javascript">
   
   
   function setModalCliente(tipo){
	  
	   if(tipo=='alta'){
		document.getElementById("VistaClientesTitulo").innerHTML ="Nuevo Cliente";
		document.getElementById("domicilio").value = "";
		document.getElementById("fCliente").setAttribute("style","display: block");
		document.getElementById("idCliente").value="";
		document.getElementById("nombreCliente").value="";
		document.getElementById("apellidoCliente").value="";
		document.getElementById("nroDocmento").value="";
		document.getElementById("telefono").value="";
		document.getElementById("mail").value="";
		document.getElementById("domicilio").value="";
		document.getElementById("estado").value="";
		document.getElementById("tdom").setAttribute("style","display: none");
		document.getElementById("btnEditar").style.visibility = "hidden"; 
		document.getElementById("btnGuardar").style.visibility = "hidden";
		document.getElementById("btnEstado").style.visibility = "hidden";
	   }
	   }
   
    function buscarCliente(){
	   
	   document.getElementById("accion1").value="buscarCliente";
	 
	   document.getElementById("fbuscarCliente").submit();
	   
	   
   }
   
   
   function nuevoCliente(){
	   
	   document.getElementById("accion").value="nuevoCliente";
	 
	   document.getElementById("fCliente").submit();
	   
	   
   }
   
function editarCliente(){
	   
	   document.getElementById("accion").value="editarCliente";
	  
	   document.getElementById("fCliente").submit();
	   
	   
   }
   
function setEstadoCliente(){
	  
	   if(document.getElementById("estado").value=="B"){
		   
		   document.getElementById("accion").value="rehabilitarCliente";
		   
	   }else{
		  document.getElementById("accion").value="bajaCliente";
		 
	   }
	  
	   
	   document.getElementById("fCliente").submit();
	   
	   
}  

   
	 function verDomicilios(){
			
			document.getElementById("fCliente").setAttribute("style","display: none");
			document.getElementById("tdom").setAttribute("style","display: block");
			
	 }
	
	 
   
   </script> 
   
</body>
</html>
