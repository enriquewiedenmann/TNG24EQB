<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   

    %>
<%@ page 
	import = "controller.CtrlEnte" 
	import = "controller.CtrlDomicilio" 
	import ="view.*"	
	import = "java.util.*"
		%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Clientes - TNG24</title>
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
                       <li  >
                        <a   href="PantallaPresupuesto.jsp"><i class="fa fa-edit fa-3x"></i>Presupuestos</a>
                    </li>
                  <li  >
                        <a class="active-menu"  href="PantallaCliente.jsp"><i class="fa fa-user  fa-3x"></i> Clientes</a>
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
                     	 <%ViewCliente vcp = (ViewCliente)request.getAttribute("viewCliente") ;
                     	 String nombre=null;
                     	
            			String apellido=null;
            			String tipoDoc=null;
            			String nroDoc=null;
            			String telefono =null;
            			String mail = null;
            			String dom = null;
            			String id = null;
            			String descDom = null;
            			String e = null;
            		
            			
                     	 if(vcp!=null){
                     		nombre = vcp.getNombre();
                     		apellido=vcp.getApellido();
                			tipoDoc=vcp.getTipoDoc().getCodTipoDoc();
                			nroDoc=vcp.getNroDoc();
                			telefono =vcp.getTelefono();
                			mail = vcp.getMail();
                			dom = vcp.getDomicilio().mostrate().getIdDomicilioString();
                			descDom = vcp.getDomicilio().mostrate().resumen();
                			id = vcp.getIdEnteString();
                			e = vcp.getEstado();
                			
                			
                			
                			
                     	 }
                     	 
                     	 
                     	 %>	
                        
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
				<button class="btn btn-danger btn-lg" data-toggle="modal" onClick="setModalBuscador()" data-target="#buscadorCliente">
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
                                       	ArrayList<ViewCliente> lista = (ArrayList<ViewCliente>) session.getAttribute("listaCliente");
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
                                        <form form="role" id="fCliente" style="display: block" method="POST" action="ClientesSERVLET">
                                        <div class="form-group">
                                        
                                            <label>Id:</label>
                                            <input value=<%=id%> id="idCliente"  name="idCliente" class="form-control" disabled/>
                                            </div>
                                        
                                        
                                        <div class="form-group">
                                        
                                            <label>Nombre:</label>
                                            <input type="text" value="<%=nombre%>" id="nombreCliente" name="nombreCliente" class="form-control" />
                                            </div>
                                         <div class="form-group">
                                            <label>Apellido:</label>
                                            
                                            <input type="text" value="<%=apellido%>" id="apellidoCliente" name="apellidoCliente" class="form-control"  />
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="tipoDocumento">Tipo Docmento:</label>
                                                <select id="tipoDocumento" name="tipoDocumento"  class="form-control">
                                        			  <%
                                        			  
                                                 		CtrlEnte sys = CtrlEnte.getInstance();
                                          				for(ViewTipoDocumento v: sys.listarTipoDocs()){
                                          					if(tipoDoc!=null){
                                          						if(v.getCodTipoDoc().equals(tipoDoc)){
                                          							
                                          							out.println(v.vistaOptionSelect());
                                          						}else{
                                          							out.println(v.vistaOption());
                                          						}
                                          					}else{
                                          						out.println(v.vistaOption());
                                          					}
                                          				}
                                                 		 %>
                                        	
                                                </select>
                                            </div>
                                             <div class="form-group">
                                            <label>Nro. Documento:</label>
                                            <input  value=<%=nroDoc%> id="nroDocmento" name="nroDocmento" class="form-control" />
                                            </div>
                                            
                                            
                                              <div class="form-group">
                                            <label>Telefono: </label>
                                            <input type="tel" value="<%=telefono%>" id="telefono"  name="telefono" class="form-control" />
                                            </div>
                                            
                                             <div class="form-group">
                                            <label>Mail: </label>
                                            <input type="email" value="<%=mail%>" id="mail" name="mail" class="form-control" />
                                            </div>
                                            <div>
                                             <label>Domicilio</label>
                                            <div class="form-group input-group">
                                            <input  value=<%=dom%> id="domicilio" name="domicilio" type="text" class="form-control">
                                            <span class="input-group-btn" >
                                                <button id="btnBuscarDomicilio" class="btn btn-default" type="button" onclick="verDomicilios()"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>
                                       <label  id="domicilioDesc" name="domicilioDesc"><%out.println(descDom);%></label> 
                                       </div>
                                       <br>
										  <div class="form-group">
                                            <label>Estado: </label>
                                            <input  value=<%=e%> id="estado"  name="estado" class="form-control" disabled/>
											
                                            </div>
											 <input type="hidden" value=<%=request.getAttribute("setModal")%> id="accion" name="accion" />
											  <input  type="hidden" id="idm" name="idm"/>   
											
										  <button type="button" class="btn btn-danger" id="btnAceptar" onClick="nuevoCliente()">Aceptar</button>
										   <button type="button" class="btn btn-danger" id="btnEditar" onClick="setOpcionEditar()">Editar</button>
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
                                            <h4 class="modal-title" id="myModalLabelB">Buscar</h4>
                                        </div>
                                        <div class="modal-body">
                                           <form form="role" id="fbuscarCliente" method="POST" action="ClientesSERVLET">	
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
										   
										   
											<input type="hidden" id="accion1" name="accion" />  
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
	
	
	
	$(document).on("click", "tr.bodyTableDom" , function(){
		
		var celda = $(this).children("#id").text();
		
		domicilio.value =celda;
		document.getElementById("domicilioDesc").innerHTML ="";
		document.getElementById("fCliente").setAttribute("style","display: block");
		document.getElementById("tdom").setAttribute("style","display: none");
		
	});
	
	$(document).on("click", "tr.bodyTableCliente" , function(){
		
		var celda = $(this).children("#id").text();
		
		idm.value=celda;
		accion.value="mostrarCliente";
		
		fCliente.submit();
		
	});

	$(document).ready(function () {
		if(accion.value=="mostarCliente"){
				accion.value==""
					document.getElementById("VistaClientesTitulo").innerHTML ="Cliente";
					
				   document.getElementById("nombreCliente").disabled = true;
				   document.getElementById("apellidoCliente").disabled = true;
				   document.getElementById("domicilio").disabled = true;
				   document.getElementById("tipoDocumento").disabled = true;
				   document.getElementById("nroDocmento").disabled = true;
				   document.getElementById("telefono").disabled = true;
				   document.getElementById("mail").disabled = true;
				   document.getElementById("estado").disabled = true;				   
				   document.getElementById("domicilio").disabled = true;
				   document.getElementById("btnBuscarDomicilio").disabled = true;
				   
				   document.getElementById("btnAceptar").style.visibility = "hidden"; 
				   document.getElementById("btnGuardar").style.visibility = "hidden";
				   if(document.getElementById("estado").value=="B"){
					   document.getElementById("btnEstado").style.visibility = "visible";
					   document.getElementById("btnEstado").innerHTML="Rehabilitar";
					   document.getElementById("btnEditar").style.visibility = "hidden"; 
				   }else{
					   document.getElementById("btnEstado").style.visibility = "hiden";
					   document.getElementById("btnEstado").innerHTML="Baja";
					   document.getElementById("btnEditar").style.visibility = "visible"; 
				   }
				    		
				
				
			 	$('#VistaClientes').modal('show');
		} 
		if(accion.value=="1"){
			accion.value==""
			alert("El cliente no pudo ser Generado");
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
			document.getElementById("domicilioDesc").innerHTML ="";
			document.getElementById("estado").value="";
			document.getElementById("nombreCliente").disabled = false;
			document.getElementById("apellidoCliente").disabled = false;
			document.getElementById("domicilio").disabled = false;
			document.getElementById("tipoDocumento").disabled = false;
			document.getElementById("nroDocmento").disabled = false;
			document.getElementById("telefono").disabled = false;
			document.getElementById("mail").disabled = false;
			document.getElementById("estado").disabled = true;				   
			document.getElementById("domicilio").disabled = false;
			document.getElementById("btnBuscarDomicilio").disabled = false;
			document.getElementById("tdom").setAttribute("style","display: none");
			document.getElementById("btnAceptar").style.visibility = "visible"; 
			document.getElementById("btnEditar").style.visibility = "hidden"; 
			document.getElementById("btnGuardar").style.visibility = "hidden";
			document.getElementById("btnEstado").style.visibility = "hidden";
			$('#VistaClientes').modal('show');
		}
		
		
		if(accion.value=="2"){
			accion.value==""
			alert("El cliente no pudo ser Editado");
			document.getElementById("VistaClientesTitulo").innerHTML ="Cliente";
			
			   document.getElementById("nombreCliente").disabled = true;
			   document.getElementById("apellidoCliente").disabled = true;
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("tipoDocumento").disabled = true;
			   document.getElementById("nroDocmento").disabled = true;
			   document.getElementById("telefono").disabled = true;
			   document.getElementById("mail").disabled = true;
			   document.getElementById("estado").disabled = true;				   
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("btnBuscarDomicilio").disabled = false;
			   
			   document.getElementById("btnAceptar").style.visibility = "hidden"; 
			   document.getElementById("btnGuardar").style.visibility = "hidden";
			   if(document.getElementById("estado").value=="B"){
				   document.getElementById("btnEstado").style.visibility = "visible";
				   document.getElementById("btnEstado").innerHTML="Rehabilitar";
				   document.getElementById("btnEditar").style.visibility = "hidden"; 
			   }else{
				   document.getElementById("btnEstado").style.visibility = "hiden";
				   document.getElementById("btnEstado").innerHTML="Baja";
				   document.getElementById("btnEditar").style.visibility = "visible"; 
			   }
				$('#VistaClientes').modal('show');
			
		}
		
		if(accion.value=="3"){
			accion.value==""
			alert("El cliente no pudo ser dado de baja");
			document.getElementById("VistaClientesTitulo").innerHTML ="Cliente";
			
			   document.getElementById("nombreCliente").disabled = true;
			   document.getElementById("apellidoCliente").disabled = true;
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("tipoDocumento").disabled = true;
			   document.getElementById("nroDocmento").disabled = true;
			   document.getElementById("telefono").disabled = true;
			   document.getElementById("mail").disabled = true;
			   document.getElementById("estado").disabled = true;				   
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("btnBuscarDomicilio").disabled = true;
			   
			   document.getElementById("btnAceptar").style.visibility = "hidden"; 
			   document.getElementById("btnGuardar").style.visibility = "hidden";
			   if(document.getElementById("estado").value=="B"){
				   document.getElementById("btnEstado").style.visibility = "visible";
				   document.getElementById("btnEstado").innerHTML="Rehabilitar";
				   document.getElementById("btnEditar").style.visibility = "hidden"; 
			   }else{
				   document.getElementById("btnEstado").style.visibility = "hiden";
				   document.getElementById("btnEstado").innerHTML="Baja";
				   document.getElementById("btnEditar").style.visibility = "visible"; 
			   }
			    		
			
			
		 	$('#VistaClientes').modal('show');
			
		}
		
		
		if(accion.value=="4"){
			accion.value==""
			alert("El cliente no pudo ser rehabilitado");
			document.getElementById("VistaClientesTitulo").innerHTML ="Cliente";
			
			   document.getElementById("nombreCliente").disabled = true;
			   document.getElementById("apellidoCliente").disabled = true;
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("tipoDocumento").disabled = true;
			   document.getElementById("nroDocmento").disabled = true;
			   document.getElementById("telefono").disabled = true;
			   document.getElementById("mail").disabled = true;
			   document.getElementById("estado").disabled = true;				   
			   document.getElementById("domicilio").disabled = true;
			   document.getElementById("btnBuscarDomicilio").disabled = true;
			   
			   document.getElementById("btnAceptar").style.visibility = "hidden"; 
			   document.getElementById("btnGuardar").style.visibility = "hidden";
			   if(document.getElementById("estado").value=="B"){
				   document.getElementById("btnEstado").style.visibility = "visible";
				   document.getElementById("btnEstado").innerHTML="Rehabilitar";
				   document.getElementById("btnEditar").style.visibility = "hidden"; 
			   }else{
				   document.getElementById("btnEstado").style.visibility = "hiden";
				   document.getElementById("btnEstado").innerHTML="Baja";
				   document.getElementById("btnEditar").style.visibility = "visible"; 
			   }
			    		
			
			
		 	$('#VistaClientes').modal('show');
			
		}
	
	
	 });
	
	
	
		</script>
   
   <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   <script type="text/javascript">
  
   function setOpcionEditar(){
	    document.getElementById("nombreCliente").disabled = false;
		document.getElementById("apellidoCliente").disabled = false;
		document.getElementById("domicilio").disabled = false;
		document.getElementById("tipoDocumento").disabled = false;
		document.getElementById("nroDocmento").disabled = false;
		document.getElementById("telefono").disabled = false;
		document.getElementById("mail").disabled = false;
		document.getElementById("estado").disabled = true;
		document.getElementById("domicilio").disabled = false; 
		document.getElementById("btnBuscarDomicilio").disabled = false;
		document.getElementById("btnEditar").style.visibility = "hidden"; 
		document.getElementById("btnGuardar").style.visibility = "visible";
		document.getElementById("btnEstado").style.visibility = "hidden";
	   
   }
   
   function setModalBuscador(){
   
   document.getElementById('bnombreCliente').value="";
   document.getElementById('bapellidoCliente').value="";
   document.getElementById('bnroDocmento').value="";
  
   }
   
   
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
		document.getElementById("domicilioDesc").innerHTML ="";
		document.getElementById("estado").value="";
		document.getElementById("nombreCliente").disabled = false;
		document.getElementById("apellidoCliente").disabled = false;
		document.getElementById("domicilio").disabled = false;
		document.getElementById("tipoDocumento").disabled = false;
		document.getElementById("nroDocmento").disabled = false;
		document.getElementById("telefono").disabled = false;
		document.getElementById("mail").disabled = false;
		document.getElementById("estado").disabled = true;				   
		document.getElementById("domicilio").disabled = false;
		document.getElementById("btnBuscarDomicilio").disabled = false;
		document.getElementById("tdom").setAttribute("style","display: none");
		document.getElementById("btnAceptar").style.visibility = "visible"; 
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
		document.getElementById("idCliente").disabled = false;
	   document.getElementById("accion").value="editarCliente";
	  
	   document.getElementById("fCliente").submit();
	   
	   
   }
   
function setEstadoCliente(){
	document.getElementById("idCliente").disabled = false;
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
