<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />


</head>
<body>
Fecha:
<div>
<div id="datepicker"></div>
</div>
     
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
  
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="jquery.ui.datepicker-es.js"></script>
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
		
		idm.value=celda;
		accion.value="mostrarCliente";
		
		fCliente.submit();
		
	});

	
	
	
		</script>
   
   <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   <script type="text/javascript">
	
	  function setModalBuscador(){
   
			document.getElementById('bNroPresupuesto').value="";
			document.getElementById('bFechaEmision').value="";
			document.getElementById('bApellido').value="";
			document.getElementById('bNombre').value="";
			document.getElementById('bDocumento').value="";
	 
  
   }
  
	
	 
	 
	 
   
   </script> 
   
</body>
</html>