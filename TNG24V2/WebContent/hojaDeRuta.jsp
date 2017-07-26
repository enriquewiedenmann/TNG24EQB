<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page 
	import = "controller.*" 
	import = "complementos.*" 
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
    <title>Hoja de Ruta - TNG24</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<style>
    #mdialTamanio{
      width: 100% !important;
    }
  </style>
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
				 <li><a class="active-menu"href="hojaDeRuta.jsp"><i class="fa fa-map-marker  fa-3x"></i> Hoja de Ruta</a></li>
                  <li><a href="PantallaAgendaCT.jsp"><i class="fa fa-table  fa-3x"></i> Agenda</a></li>	
                 <li><a href="PantallaPresupuesto.jsp"><i class="fa fa-edit fa-3x"></i>Presupuestos</a></li>
				</ul>
            </div>
        </nav>  
        <!-- FIN PANTALLA INICIO -->

<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDyxCvKrtb7cPFUsdQvZ8QCKegl-KrUtJ0"></script>
<script>
var geocoder;
  var i = new Array();
  
  function initialize(nro) {
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(-34.397, 54.644);
    var mapOptions = {
      zoom: 15,
      center: latlng
    }
    i[nro] = new google.maps.Map(document.getElementById('map' + nro), mapOptions);
  }

  function codeAddress(address,nro) {
	 initialize(nro)
	//var address = "Cabildo 1334 Capital Federal Argentina";
    //var address = document.getElementById('address').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == 'OK') {
        i[nro].setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: i[nro],
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
</script>






<!-- /. NAV SIDE  -->
        <div id="page-wrapper"">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Hoja de ruta </h2>   
                     
						
						
						<br>
                       
                    </div>
                </div>
				
			
			
			
				
				
			<!-- Nuevo elemento -->
			<%
			
			
			
			
			CtrlAgenda sys= CtrlAgenda.getInstance();
		Date hoy = FechasAux.getInstance().toDateDDMMYYY("14/07/2017");
		int i = 40;
		ViewAgenda a = sys.listarVisitas(hoy, i);
			
			for(ViewVisita v:a.getVVV() ){%>
				 <div class="row">
	                <div class="col-md-12 col-sm-12">
	                    <div class="panel panel-info">
	                        <div class="panel-heading">
				<%out.println(v.getInicioProgramadoHHMM()+" - "+v.getFinProgramadoHHMM());%></div>
				 <div class="panel-body">
				  <p><strong><%out.println(v.getMotivo());%></strong>
				  </br>
							</br><u>Nro Cliente:</u><%out.println(v.getCliente().getIdEnte());%>
							</br><u>Contacto:</u> <%out.println(v.getCliente().getApellido()+", "+v.getCliente().getNombre());%>
							</br><u>Teléfono:</u> <%out.println(v.getCliente().getTelefono()); %>
							</br><u>Direccion:</u><%out.println(v.getDomicilio().mostrate().resumen()); %>
						 <div  id=<%out.println("map"+v.getId());%> style="width: 400px; height: 400px;"></div>
							
							v.getDomicilio().mostrate()
					
                        </div>
                        <div class="panel-footer">
                        	
                             <button onclick=<%out.println("ver("+v.getDomicilio().getCalle()+" "+v.getDomicilio().getNumero()+" "+v.getDomicilio().getDescLocalidad());%>,<%out.println(v.getId()+")");%>>dos</button>
                            <a href="#" class="btn btn-primary">Presupuesto</a> &nbsp;&nbsp;
							<a href="#" class="btn btn-primary">Factura</a>&nbsp;&nbsp;
							<a href="#" class="btn btn-primary">Finalizar</a>
							
                        </div>
                    </div>
                </div>
            </div>
		<%} %>
            
	
<!-- FIN DE PAGINA -->

    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-6">
                       
                     <!--  Modals-->
                   
                        
                       
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                              Click  Launch Demo Modal
                            </button>
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title Here</h4>
                                        </div>
                                        <div  class="modal-body">
                                        
                                        <div  id="map1" style="width: 400px; height: 400px;"></div>
                                         
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button  type="button" class="btn btn-primary">Ver</button>
                                       
                                        </div>
                                     </div>
                                </div>
                            </div>
                        
                 
                     <!-- End Modals-->        
      
 <script type="text/javascript">
 function ver(dir,id){
		codeAddress(dir,id);
	
		}
											</script>         
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').dataTable({
             
            });
        });
    </script>
         <!-- CUSTOM SCRIPTS -->
</body>
</html>