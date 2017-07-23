<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div type="hidden" >
        <form form="role" id="fAltaPresupuesto" method="POST" action="PresupuestoDetalleSERVLET">
         <input  type="hidden" id="accion" name="accion"/>
        <input  type="hidden" id="idnp" name="idnp"/>
        
        </form>
        </div>
          <button type="button" class="btn btn-danger" onClick="nuevoPresupuesto()">Presupuesto</button>
        
        <script>
        
        function nuevoPresupuesto(){
        	document.getElementById("accion").value = "altaPresupuesto";
        	document.getElementById("idnp").value = "11" // aca va el ID visita
        	fAltaPresupuesto.submit();
        	
        	
        }
        
        
        </script>
</body>
</html>