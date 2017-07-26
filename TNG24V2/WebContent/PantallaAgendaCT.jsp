<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page 
	import = "controller.CtrlEnte" 
	import = "controller.CtrlDomicilio" 
	import ="view.*"	
	import = "java.util.*"
		%>   
		
<%	

HttpSession sessionUsuario = request.getSession(true);
if(sessionUsuario != null && sessionUsuario.getAttribute("currentUser") == null){
	request.setAttribute("noSessionMessage", "Por favor, inicie sesión para continuar.");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	  <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600" rel="stylesheet">
	<link rel="stylesheet" href="assets/css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="assets/css/style.css"> <!-- Resource style -->
  	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link rel="stylesheet" href="assets/css/jquery-ui.css" />
	<title>Agenda - TNG24</title>
</head>
<body>

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
 	<button class="btn btn-info square-btn-adjust pull-left" style="margin-right:3px;">
	<%
		HttpSession session1 = request.getSession(true);
		if(session1.getAttribute("currentUser") != null ){
			String rol = (String) session1.getAttribute("rol");
			if(rol.equals("TEC")){
				%>Técnico: <%=session1.getAttribute("currentUser")%><%
			}
			else{
				%>Coordinador: <%=session1.getAttribute("currentUser")%><%
			}
		}
		
	%>
	</button>
 	<form action="LoginServlet" method="POST" class="pull-right">
 		<input type="hidden" value="logout" name="logout"> 
 	<button type="submit" class="btn btn-danger square-btn-adjust">Salir</button>
 	</form> 
	 </div>
        
        </nav>     
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
             <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
					<li class="text-center"><img src="assets/img/find_user.png" class="user-image img-responsive" /></li>
				 <li><a href="PantallaCliente.jsp"><i class="fa fa-user  fa-3x"></i> Clientes</a></li>
				 <li><a href="hojaDeRuta.jsp"><i class="fa fa-map-marker  fa-3x"></i> Hoja de Ruta</a></li>
                  <li><a class="active-menu" href="PantallaAgendaCT.jsp"><i class="fa fa-table  fa-3x"></i> Agenda</a></li>	
                 <li><a href="PantallaPresupuesto.jsp"><i class="fa fa-edit fa-3x"></i>Presupuestos</a></li>
				</ul>
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
              <div class="row">
                    <div class="col-md-4">
                     <h2>Agenda</h2>
                     <form form="role" id="fbuscarAgendas" method="POST" action="AgendaCTSERVLET">
	                     <div class="form-group" >
	                        <label>Dia:</label>
							<input type="text" id="datepicker" name="fecBucada"  class="form-control"  readonly="readonly" style="cursor:pointer;"/>	
	                     </div>
	                     <input  type="hidden" id="buscar" name="buscar"/>
	                     <button type="button" class="btn btn-danger" onClick="buscarVisitas()">Buscar</button> 
	                     <button type="button" class="btn btn-danger" onClick="irNuevo()" >Nuevo</button>                        
	                  </form>   
                     	
                        
                    </div>
                </div>
                    
<div class="cd-schedule loading">
	<div class="timeline">
		<ul>
			<li><span>09:00</span></li>
			<li><span>09:30</span></li>
			<li><span>10:00</span></li>
			<li><span>10:30</span></li>
			<li><span>11:00</span></li>
			<li><span>11:30</span></li>
			<li><span>12:00</span></li>
			<li><span>12:30</span></li>
			<li><span>13:00</span></li>
			<li><span>13:30</span></li>
			<li><span>14:00</span></li>
			<li><span>14:30</span></li>
			<li><span>15:00</span></li>
			<li><span>15:30</span></li>
			<li><span>16:00</span></li>
			<li><span>16:30</span></li>
			<li><span>17:00</span></li>
			<li><span>17:30</span></li>
			<li><span>18:00</span></li>
		</ul>
	</div> <!-- .timeline -->

	<div class="events">
		<ul>
		<%ArrayList<ViewAgenda> lista=(ArrayList<ViewAgenda>)session.getAttribute("listaAgTec"); 
		String fecha=null;
		 if(lista!=null){
			fecha = (String)session.getAttribute("fecha");
            	for(ViewAgenda va: lista){
            		out.println("<li class=\"events-group\">");
            		out.println("<div class=\"top-info\"><span>"+va.getTecnico().getApellido()+", "+va.getTecnico().getNombre()+"</span></div><ul>");
               		for(ViewVisita vv : va.getVVV()){
               			out.println("<li class=\"single-event\" data-start=\""+
               						vv.getInicioProgramadoHHMM()+"\" data-end=\""+
               						vv.getFinProgramadoHHMM()+"\"data-event=\"event-1\">"+
               						"<a href=\"#0\"><em class=\"event-name\">"+
               						vv.getMotivo()+"</em>"+
               						"<div style=\"display: none\" class=\"event-idVisita\">"+vv.getId()+"</div>"+
               						"<div style=\"display: none\" class=\"event-cliente\">"+vv.getCliente().getApellido()+", "+vv.getCliente().getNombre()+"</div>"+
               						"<div style=\"display: none\" class=\"event-domicilio\">"+vv.getDomicilio().mostrate().resumen()+"</div>"+
               						"</a></li>");

               		}
               		out.println("</ul></li>");
            	}
            	}
                      		 %>  
		
		</ul>
	</div>

	<div class="event-modal">
		<header class="header">
			<div class="content">
				<span class="event-date"></span>
				<h3 class="event-name"></h3>
				
				
			</div>

			<div class="header-bg"></div>
		
		</header>

		<div class="body">
		
			<div id="cuerpo" class="event-info">
				<br>
				<form form="role" id="resVisita"  method="POST" action="VisitaDetalleSERVLET">
				<div class="form-group">                                        
                 <label>Id:</label>
                 <input id="idVisita"  name="idVisita" class="form-control" disabled/></div>
                 <div class="form-group">
                 <label>Cliente: </label><input id="modalCliente" class="form-control" disabled />
                 </div>
                 <div class="form-group">
                 <label>Domicilio: </label><input id="modalDomicilio" class="form-control" disabled />
                 </div>
                 <input type="hidden" id="accion"  name="accion" />
                 <input value=<%=fecha%> type="hidden" id="bmfecbuscada"  name="bmfecbuscada" />
                 <button type="button" class="btn btn-danger" id="btnEstado" onClick="accionVisita('baja')">Baja</button>
                 <button type="button" class="btn btn-danger" id="btnMostrar" onClick="accionVisita('mostrar')">Detalle</button>
                 </form>
		
			</div>
			<div class="body-bg"></div>
		</div>
		<a href="#0" class="close">Close</a>
		
	</div>
	

	<div class="cover-layer"></div>
</div> <!-- .cd-schedule -->
</div>

 
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>

        
        
        
        
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
<script src="assets/js/agTecnico/modernizr.js"></script>
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>-->
<script>
	if( !window.jQuery ) document.write('<script src="assets/js/agTecnico/jquery-3.0.0.min.js"><\/script>');
</script>
<script src="assets/js/agTecnico/main.js"></script><!-- Resource jQuery -->
<script>
function buscarVisitas(){
	 document.getElementById("buscar").value="buscar";
	 document.getElementById("fbuscarAgendas").submit();
	
}

</script>
<script>
function accionVisita(accion){
	
	document.getElementById("idVisita").disabled = false;
	document.getElementById("accion").value=accion;
		resVisita.submit();
	
}

function irNuevo(){
	window.location.href="PantallaDetalleVisita.jsp";
}


</script>

</body>
</html>