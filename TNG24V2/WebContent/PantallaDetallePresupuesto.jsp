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
  <title>Presupuesto - TNG24</title>
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

<%ViewPresupuesto vp = (ViewPresupuesto)session.getAttribute("presupuesto") ;
                     	 String nombre=null;
                     	
                     	String id=null;
                    	String fechaEmision=null;
                    	String cliente=null;
                    	String motivo = null;
                    	String tiempoManoObra=null;
                    	String montoManoObra=null;
                    	String tecnico=null;
                    	String estado = null;
                    	estado = (String)request.getAttribute("estado");
                    	String error ="";
                    	error= (String)request.getAttribute("error");
                    	ArrayList<ViewItemDocumento> vli=new ArrayList<ViewItemDocumento>();
                    	int tot=0;
                    	
                     	 if(vp!=null){
                     		if(vp.getId()!=0){
                     		id=Integer.toString(vp.getId());
                     		}else{
                     			id="-";
                     		}
                     		if(!(vp.getFechaEmision()==null)){
                     		fechaEmision=vp.getFechaEmision().toString();
                     		}else{
                     			fechaEmision="-";
                     		}
                        	cliente=vp.getCliente().getApellido()+", "+vp.getCliente().getNombre();
                        	tiempoManoObra=Integer.toString(vp.getTiempoManoObra());
                        	montoManoObra=Integer.toString(vp.getMontoManoObra());
                        	tot=Integer.parseInt(montoManoObra);
                        	tecnico=vp.getTecnico().getApellido()+", "+vp.getTecnico().getNombre();
                        	motivo = vp.getMotivo();
                			
                			
                			
                     	 }
                     	 
                     	 
                     	 %>
                     	 
    <input type="hidden" id="estado" name="estado" value="<%=estado%>" /> 	
    <input type="hidden" id="error" name="error" value="<%=error%>" /> 	
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
        <h4 id="tituloPantalla">Presupuesto Numero: <%out.println(id); %></h4>
      </div>
      <div class="w-clearfix w-col w-col-6 w-col-small-6 w-col-tiny-6">
        <h5 id="fechaEmision" class="fecha">Fecha de Emision: <%out.println(fechaEmision); %></h5>
      </div>
    </div>
  </div>
  
 
        <div class="rowdatoscliente w-row">
      
         
         
          <div class="w-col w-col-1 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="Cliente">Cliente:</label>
          </div>
          <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=cliente%>" class="fieldnombre w-input" data-name="Cliente" id="Cliente" maxlength="256" name="Cliente"  type="text">
          </div>
          <div class="w-col w-col-1 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="Cliente">Descripcion:</label>
          </div>
          <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=motivo%>" class="fieldnombre w-input" data-name="Motivo" id="Motivo" maxlength="256" name="Cliente"  type="text">
          </div>
        </div>
        <br>
        <br>
        <label class="labeldato" for="Cliente">Detalle de Productos:</label>
       <div class="table-responsive table table-condensed">
     
       <button id="btnNuevoItem" class="btn btn-default btn-sm"  data-toggle="modal"  onClick=""  data-target="#altaItemModal">
       
                            +
                            </button> 
                                <table class="table  table-bordered " id="tablaItemsPresupeusto">
                                    <thead>
                                        <tr>
                                        	<th style="display: none;">nro</th>
                                            <th>Descripcion</th>
                                            <th>Codigo</th>
                                            <th>Cantidad</th>
                                            <th>Valor</th>
                                            
											
                                        </tr>
                                    </thead>
                                    <tbody>
									  <%                             			  
									  
                                                 		
                                          				for(ViewItemDocumento v: vp.getVli()){
                                          					
                                          							out.println(v.vistaTabla());
                                          							tot=tot+v.getMontoItem();
                                          					
                                          				}
                                                 		 %>
									
                                    	
										
                                    </tbody>
                                </table>
                               
                            </div>	
                            <div>
            
           <div class="rowdatoscliente w-row">    
           <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="monto">Mano de Obra:</label>
          </div>
          <div class="w-col w-col-5 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=montoManoObra%>" class="fieldnombre w-input" data-name="monto" id="monto" maxlength="256" name="monto" type="text">
          </div>
          			
          			 </div>	
          			 
               <div class="rowdatoscliente w-row">    
           <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="total">Total:</label>
          </div>
          <div class="w-col w-col-5 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=tot%>" class="fieldnombre w-input" data-name="total" id="total" maxlength="256" name="total" type="text">
          </div>
          			
          			 </div>	
          
        	<br>
        	<br>
        	 <label class="labeldato" >Otros Datos:</label>
        	
          			 <div class="rowdatoscliente w-row">                   
         <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="tecnico">Tecnico:</label>
          </div>
          <div class="w-col w-col-5 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=tecnico%>" class="fieldnombre w-input" data-name="tecnico" id="tecnico" maxlength="256" name="tecnico" type="text">
          </div>
          </div>
           <div class="rowdatoscliente w-row">        
           <div class="w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="tiempo">Tiempo Estimado (En minutos):</label>
          </div>
          <div class="w-col w-col-5 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input  value="<%=tiempoManoObra%>" class="fieldnombre w-input" data-name="tiempo" id="tiempo" maxlength="256" name="tiempo" type="text">
          </div>
           </div>
       </div>
        <input type="hidden"  id="accion" name="accion"  />
  <button type="button" class="btn btn-danger" id="btnCerrarPresupuesto" onClick="cerrarPresupuesto()">Aceptar</button>
  
 
  
  
  
  

  
  
  
   <div type="hidden" >
        <form form="role" id="faccionItem" method="POST" action="PresupuestoDetalleSERVLET">
         <input  type="hidden" id="bajaItem" name="bajaItem"/>
        <input  type="hidden" id="idip" name="idip"/>
        
        </form>
             <form form="role" id="faccionCerrarPresupuesto" method="POST" action="PresupuestoDetalleSERVLET">
         <input  type="hidden" id="cerrarPresupuesto" name="cerrarPresupuesto"/>
 		<input  type="hidden" id="cpmonto" name="cpmonto"/>
 		<input  type="hidden" id="cptiempo" name="cptiempo"/>
		<input  type="hidden" id="cpmotivo" name="cpmotivo"/>
        </form>
        
        </div>
        <!--  INICIO DEL MODAL -->
         <div name="modales">
           <div class="modal fade" id="altaItemModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"   >
                                <div class="modal-dialog" id="mdialTamanio">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 id="VistaClientesTitulo" class="modal-title" id="myModalLabel">Alta Item</h4>
                                        </div>
                                        <div class="modal-body">
                                        <div id="fItem" style="display: block">
                                        <form form="role"  id="nuevoItem" method="POST" action="PresupuestoDetalleSERVLET">
                                        <div class="form-group">
                                                                               
                                            <div>
                                             <label>Producto:</label>
                                            <div class="form-group input-group">
                                            <input  id="codProductoModal" name="codProductoModal" type="text" class="form-control" disabled/>
                                            <span class="input-group-btn" >
                                                <button id="btnBuscarProducto" class="btn btn-default" type="button" onclick="verProductos()"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                                                                   
                                        </div>
                           
                                       </div>
                                      
										  <div class="form-group">
                                            <label>Cantidad:</label>
                                            <input  id="cantProductoModal"  name="cantProductoModal" class="form-control" type="number"/>
											
                                            </div>
											 <input type="hidden"  id="altaItem" name="altaItem" />
											
											
										  <button type="button" class="btn btn-danger" id="btnAceptar" onClick="nuevoItem()">Aceptar</button>
										  
											</div> 
             			             </form>
                                        </div>
							<div class="panel-body" id="tProd"  style="display: none">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="tablaProductos">
                                    <thead>
                                        <tr>
                                            <th>Codigo:</th>
                                            <th>Descripcion:</th>
                                            <th>Precio:</th>
                                           
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
									
									<%
                                       CtrlProducto ctrlp = CtrlProducto.getInstancia();
										for(ViewProducto p: ctrlp.listarProductos()){
											out.println(p.vistaTabla());
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
<!-- INICIA INSERT LOGICA MODAL -->

 <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      
    <!-- DATA TABLE SCRIPTS     -->

   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>

$(document).ready(function () {$('#tablaProductos').dataTable();});			
							
	</script>



<!-- FIN INSERT LOGICA MODAL -->
<script type="text/javascript">
$(document).on("click", "tr.bodytablaItemP" , function(){
	
		var celda = $(this).children("#id").text();
		
		bajaItem.value="bajaItem";
		idip.value =celda;
	
		faccionItem.submit();
		
}
);

$(document).on("click", "tr.bodyTableProd" , function(){
	
	var celda = $(this).children("#id").text();
	
	
	codProductoModal.value=celda;
	document.getElementById("fItem").setAttribute("style","display: block");
	document.getElementById("tProd").setAttribute("style","display: none");
	
});						
	
	</script>


<script>

function setPage(){
	
	var estado = document.getElementById("estado").value;
	var error = document.getElementById("error").value;
	
	if(estado=="mostrar"){
		document.getElementById("Cliente").disabled = true;
		document.getElementById("Motivo").disabled = true;
		document.getElementById("monto").disabled = true;
		document.getElementById("total").disabled = true;
		document.getElementById("tecnico").disabled = true;
		document.getElementById("tiempo").disabled = true;
		//document.getElementById("bajaItem").value="";
		 document.getElementById("accion").value="";
		 document.getElementById("btnCerrarPresupuesto").style.visibility = "hidden";
		 document.getElementById("btnNuevoItem").style.visibility = "hidden";
			
	}
	
	
	if(estado=="alta"){
		document.getElementById("Cliente").disabled = true;
		document.getElementById("Motivo").disabled = false;
		document.getElementById("monto").disabled = false;
		document.getElementById("total").disabled = true;
		document.getElementById("tecnico").disabled = true;
		document.getElementById("tiempo").disabled = false;
		document.getElementById("monto").type="number";
		//document.getElementById("bajaItem").value="";
		document.getElementById("accion").value="";
		// document.getElementById("altaItem").value="";
		 document.getElementById("btnCerrarPresupuesto").style.visibility = "visible";
		 document.getElementById("btnNuevoItem").style.visibility = "visible";
		
	}
	
	if(error!=null){
		alert(error);
	}

	
}

function nuevoItem(){
	
alert("nuevoI");
document.getElementById("codProductoModal").disabled = false;

	 document.getElementById("altaItem").value="altaItem";
	 document.getElementById("accion").value="";
	 alert(document.getElementById("altaItem").value);
	 document.getElementById("nuevoItem").submit();
	
}

function setModal() {
	
	document.getElementById("codProductoModal").value="";
	document.getElementById("cantProductoModal").value="";
	document.getElementById("codProductoModal").disabled = true;
	
}

function verProductos(){
	
	document.getElementById("fItem").setAttribute("style","display: none");
	document.getElementById("tProd").setAttribute("style","display: block");
	
}	

 function cerrarPresupuesto(){
	 alert("cerrarP");
	// document.getElementById("altaItem").value="";
	 //document.getElementById("bajaItem").value="";
	 
	  document.getElementById("cptiempo").value=document.getElementById("tiempo").value;
	  document.getElementById("cpmonto").value=document.getElementById("monto").value;
	  document.getElementById("cpmotivo").value=document.getElementById("Motivo").value;
	 document.getElementById("cerrarPresupuesto").value="cerrarPresupuesto";
	 document.getElementById("faccionCerrarPresupuesto").submit();
	 
	 
    }
    

</script>




</body>
</html>