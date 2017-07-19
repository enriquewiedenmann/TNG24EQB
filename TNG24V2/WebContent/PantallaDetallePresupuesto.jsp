<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="view.*"
    import = "java.util.*"	
    %>

	<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Sun Apr 23 2017 07:20:16 GMT+0000 (UTC)  -->
<html data-wf-page="58fc37d167a8320d4f298aed" data-wf-site="58fc160f3df4dd7655b11a5a">
<head>
  <meta charset="utf-8">
  <title>CrearPresupuesto</title>
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
<body>
<%ViewPresupuesto vp = (ViewPresupuesto)request.getAttribute("presupuesto") ;
                     	 String nombre=null;
                     	
                     	String id=null;
                    	String fechaEmision=null;
                    	String cliente=null;
                    	String tiempoManoObra=null;
                    	String montoManoObra=null;
                    	String tecnico=null;
                    	ArrayList<ViewItemDocumento> vli=new ArrayList<ViewItemDocumento>();
                    	int tot=0;
                    	
                     	 if(vp!=null){
                     		id=Integer.toString(vp.getId());
                     		fechaEmision=vp.getFechaEmision().toString();
                        	cliente=vp.getCliente().getApellido()+", "+vp.getCliente().getNombre();
                        	tiempoManoObra=Integer.toString(vp.getTiempoManoObra())+" minutos";
                        	montoManoObra=Integer.toString(vp.getMontoManoObra());
                        	tot=Integer.parseInt(montoManoObra);
                        	tecnico=vp.getTecnico().getApellido()+", "+vp.getTecnico().getNombre();
                        	
                			
                			
                			
                     	 }
                     	 
                     	 
                     	 %>	
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
  <div class="presupuesto">
    <div class="w-form">
      <form data-name="Email Form" id="email-form" name="email-form">
        <div class="rowdatoscliente w-row">
      
         
         
          <div class="w-col w-col-1 w-col-small-small-stack w-col-tiny-tiny-stack">
            <label class="labeldato" for="Cliente">Cliente:</label>
          </div>
          <div class="w-col w-col-11 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input value="<%=cliente%>" class="fieldnombre w-input" data-name="Cliente" id="Cliente" maxlength="256" name="Cliente"  type="text">
          </div>
        </div>
        
       <div class="table-responsive table table-condensed">
                                <table class="table  table-bordered " id="tablaItemsPresupeusto">
                                    <thead>
                                        <tr>
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
                                          							//tot=tot+v.getMontoItem();
                                          					
                                          				}
                                                 		 %>
									
                                    	
										
                                    </tbody>
                                </table>
                            </div>	
                            <div >
          
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
            <label class="labeldato" for="tiempo">Tiempo Estimado:</label>
          </div>
          <div class="w-col w-col-5 w-col-small-small-stack w-col-tiny-tiny-stack">
            <input  value="<%=tiempoManoObra%>" class="fieldnombre w-input" data-name="tiempo" id="tiempo" maxlength="256" name="tiempo" type="text">
          </div>
           </div>
          			 
          			 
      
      </form>
     
    </div>
  </div>
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>--> 
  <script src="assets/js/webflow.js" type="text/javascript"></script>
</body>
</html>