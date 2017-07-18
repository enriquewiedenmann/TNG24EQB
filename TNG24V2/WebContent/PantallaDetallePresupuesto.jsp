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
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/tng24.webflow.css" rel="stylesheet" type="text/css">
  <script src="js/modernizr.js" type="text/javascript"></script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
</head>
<body>
<%ViewPresupuesto vp = (ViewPresupuesto)request.getAttribute("ViewPresupuesto") ;
                     	 String nombre=null;
                     	
                     	String id=null;
                    	String fechaEmision=null;
                    	String cliente=null;
                    	String tiempoManoObra=null;
                    	String montoManoObra=null;
                    	String tecnico=null;
                    	ArrayList<ViewItemDocumento> vli=new ArrayList<ViewItemDocumento>();
                    	
                    	
                     	 if(vp!=null){
                     		id=Integer.toString(vp.getId());
                     		fechaEmision=vp.getFechaEmision().toString();
                        	cliente=vp.getCliente().getApellido()+", "+vp.getCliente().getNombre();
                        	tiempoManoObra=Integer.toString(vp.getTiempoManoObra())+" minutos";
                        	montoManoObra=Integer.toString(vp.getMontoManoObra());
                        	tecnico=vp.getTecnico().getApellido()+", "+vp.getTecnico().getNombre();
                        	
                			
                			
                			
                			
                     	 }
                     	 
                     	 
                     	 %>	

  <div class="nuevopresupuesto seccionhojaderuta">
    <div class="rowhojaderuta w-row">
      <div class="w-col w-col-6 w-col-small-6 w-col-tiny-6">
        <h4 id="tituloPantalla">Nuevo Presupuesto</h4>
      </div>
      <div class="w-clearfix w-col w-col-6 w-col-small-6 w-col-tiny-6">
        <h5 id="fechaEmision" class="fecha">20/04/2017</h5>
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
            <input class="fieldnombre w-input" data-name="Cliente" id="Cliente" maxlength="256" name="Cliente" placeholder="Nombre del cliente" type="text">
          </div>
        </div>
        <div class="rowdatoscliente w-row">
          <div class="w-col w-col-1">
            <label class="labeldato" for="Direccion">Dirección:</label>
          </div>
          <div class="w-col w-col-11">
            <input class="fielddireccion w-input" data-name="Direccion" id="Direccion" maxlength="256" name="Direccion" placeholder="Dirección del cliente" type="text">
          </div>
        </div>
        <ul class="listadoitemspresupuesto w-list-unstyled">
          <li class="listitempresupuesto">
            <div class="rowitempresupuesto w-hidden-small w-hidden-tiny w-row">
              <div class="colitems1 w-col w-col-8">
                <div class="textblockdes">Descripción</div>
              </div>
              <div class="colitems1 w-col w-col-2">
                <div class="textblockdes">Código</div>
              </div>
              <div class="colitems1 w-col w-col-1">
                <div class="textblockdes">Cantidad</div>
              </div>
              <div class="colitems1 w-col w-col-1">
                <div class="textblockdes">Valor</div>
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8 w-col-small-small-stack w-col-tiny-tiny-stack">
                <input class="textfielditem w-input" data-name="item" id="item" maxlength="256" name="item" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2 w-col-small-small-stack w-col-tiny-tiny-stack">
                <input class="textfielditem w-input" data-name="Codigo" id="Codigo" maxlength="256" name="Codigo" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1 w-col-small-small-stack w-col-tiny-tiny-stack">
                <input class="textfielditem w-input" data-name="Cantidad" id="Cantidad" maxlength="256" name="Cantidad" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1 w-col-small-small-stack w-col-tiny-tiny-stack">
                <input class="textfielditem w-input" data-name="Valor" id="Valor" maxlength="256" name="Valor" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 2" id="item-2" maxlength="256" name="item-2" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 2" id="Codigo-2" maxlength="256" name="Codigo-2" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 2" id="Cantidad-2" maxlength="256" name="Cantidad-2" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 2" id="Valor-2" maxlength="256" name="Valor-2" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 3" id="item-3" maxlength="256" name="item-3" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 3" id="Codigo-3" maxlength="256" name="Codigo-3" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 3" id="Cantidad-3" maxlength="256" name="Cantidad-3" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 3" id="Valor-3" maxlength="256" name="Valor-3" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 4" id="item-4" maxlength="256" name="item-4" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 4" id="Codigo-4" maxlength="256" name="Codigo-4" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 4" id="Cantidad-4" maxlength="256" name="Cantidad-4" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 4" id="Valor-4" maxlength="256" name="Valor-4" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 5" id="item-5" maxlength="256" name="item-5" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 5" id="Codigo-5" maxlength="256" name="Codigo-5" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 5" id="Cantidad-5" maxlength="256" name="Cantidad-5" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 5" id="Valor-5" maxlength="256" name="Valor-5" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 6" id="item-6" maxlength="256" name="item-6" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 6" id="Codigo-6" maxlength="256" name="Codigo-6" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 6" id="Cantidad-6" maxlength="256" name="Cantidad-6" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 6" id="Valor-6" maxlength="256" name="Valor-6" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 7" id="item-7" maxlength="256" name="item-7" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 7" id="Codigo-7" maxlength="256" name="Codigo-7" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 7" id="Cantidad-7" maxlength="256" name="Cantidad-7" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 7" id="Valor-7" maxlength="256" name="Valor-7" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <input class="textfielditem w-input" data-name="Item 8" id="item-8" maxlength="256" name="item-8" placeholder="Descripción" type="text">
              </div>
              <div class="colitems1 w-col w-col-2">
                <input class="textfielditem w-input" data-name="Codigo 8" id="Codigo-8" maxlength="256" name="Codigo-8" placeholder="Código" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Cantidad 8" id="Cantidad-8" maxlength="256" name="Cantidad-8" placeholder="Cant" type="text">
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 9" id="Valor-9" maxlength="256" name="Valor-9" placeholder="Valor" type="text">
              </div>
            </div>
            <div class="rowitempresupuesto w-row">
              <div class="colitems1 w-col w-col-8">
                <div>
                  <div class="textblockdes texttotal"></div>
                </div>
              </div>
              <div class="colitems1 w-col w-col-2">
                <div class="textblockdes texttotal"></div>
              </div>
              <div class="colitems1 w-col w-col-1">
                <div class="textblockdes texttotal">Total</div>
              </div>
              <div class="colitems1 w-col w-col-1">
                <input class="textfielditem w-input" data-name="Valor 8" id="Valor-8" maxlength="256" name="Valor-8" placeholder="Valor" type="text">
              </div>
            </div>
          </li>
        </ul>
        <input class="btnguardar w-button" data-ix="hoverboton" data-wait="Guardando..." type="submit" value="Guardar">
      </form>
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form</div>
      </div>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>