<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Iniciar Sesión</title>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${ctx}/images/favicon.ico"
	type="image/x-icon" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top  navbar-fixed-top"
			role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">TNG24</a> <a class="navbar-brand"
					href="#">Técnico</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				26 de Mayo de 2017 &nbsp;
				<!--  <li class="logout"><a id="logout" href="${ctx}/logout">Logout</a>  </li>-->
				<a href="/logout" class="btn btn-danger square-btn-adjust">Logout</a>
			</div>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="assets/img/find_user.png"
						class="user-image img-responsive" /></li>
					<!--<li><a href="clientes"><i class="fa fa-desktop fa-3x"></i>
								Clientes</a></li>
						<li><a href="hojaderuta"> <i
								class="fa fa-dashboard fa-3x"></i> Hoja de ruta
						</a></li>
						<li><a href="agenda"> <i class="fa fa-dashboard fa-3x"></i>Agenda
						</a></li>
						<li><a href="presupuestos"><i class="fa fa-qrcode fa-3x"></i>
								Presupuestos</a></li>
						<li><a href="facturas"><i class="fa fa-qrcode fa-3x"></i>Facturas</a></li>
						<li><a href="desempeño"><i
								class="fa fa-bar-chart-o fa-3x"></i>Desempeño Técnicos</a></li>
						<li><a href="usuarios"><i class="fa fa-desktop fa-3x"></i>Usuarios</a></li>
						<li><a href="encuesta"><i class="fa fa-edit fa-3x"></i>Encuestas</a></li>
						<li><a href="facturas"><i class="fa fa-bar-chart-o fa-3x"></i>
								Facturas</a></li>
						<li><a href="stock"><i class="fa fa-table fa-3x"></i>Stock</a></li> -->
				</ul>
			</div>
		</nav>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="well">
						<%  	if (request != null){ 
							String error = (String) request.getAttribute("loginError");
							if( error != null  && error.equals("invalid")){
							%>
								<div class="alert alert-danger alert-dismissable">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										<strong> Credenciales Invalidas</strong>
									</div>
							<% }
						}%>
						
									 
						
								
							<form method="post" action="LoginServlet" action="login"
								class="form-signin" autocomplete="off">
								<div class="form-group">
									<label for="usuario">Usuario</label> <input type="text"
										class="form-control" id="usuario" placeholder="Usuario"
										name="usuario" id="usuario" placeholder="Usuario" required
										tabindex="1">
								</div>
								<div class="form-group">
									<label for="contraseña">Contraseña</label> <input
										type="password" class="form-control" id="contraseña"
										placeholder="Contraseña" name="contraseña"
										placeholder="Contraseña" required tabindex="2" required>
								</div>
								<button type="submit" class="btn btn-large btn-success"
									name="login" id="login" tabindex="3">Iniciar Sesión</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>






	<script type="text/javascript">
		$('a[href="${pageContext.request.requestURI}"]').parent().addClass(
				'active');
	</script>

</body>
</html>
