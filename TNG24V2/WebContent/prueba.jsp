<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>jQuery UI Datepicker - Opciones de localización</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="jquery.ui.datepicker-es.js"></script>

<script>
$(function () {
$.datepicker.setDefaults($.datepicker.regional["es"]);
$("#datepicker").datepicker({
firstDay: 1
});
});
</script>
</head>

<body>
Fecha:
<div>
<div id="datepicker"></div>
</div>
</body>
</html>